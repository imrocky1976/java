import com.google.protobuf.InvalidProtocolBufferException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ClubSerializeHandler {
    private static Logger logger = LogManager.getLogger(MyJedis.class);
    private MyJedis myJedis;

    public ClubSerializeHandler(MyJedis j) {
        myJedis = j;
    }

    public byte[] serialize(ClubOuterClass.Club club) {
        return club.toByteArray();
    }

    public ClubOuterClass.Club deserialize(byte[] bytes) {
        try {
            return ClubOuterClass.Club.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public boolean setToRedis(ClubOuterClass.Club club) {
        String key = String.format("club:%d", club.getId());
        String ret = myJedis.set(key.getBytes(), serialize(club));
        return ret.equals("OK") ? true : false;
    }

    public ClubOuterClass.Club getFromRedis(String key) {
        byte[] data = myJedis.get(key.getBytes());
        if (data == null)
            return null;
        return deserialize(data);
    }
}
