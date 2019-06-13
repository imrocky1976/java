import org.junit.Test;
import org.junit.Assert;
import com.google.protobuf.Timestamp;
import java.time.Instant;

public class ClubSerializeHandlerTest {
    @Test
    public void testClubSerialize() {
        MyJedis myJedis = new MyJedis("dp-shihj", 6379);

        ClubOuterClass.Club.Builder clubBuilder = ClubOuterClass.Club.newBuilder();
        clubBuilder.setId(1);
        clubBuilder.setName("yinxinghu golf");
        clubBuilder.setInfo("yinxinghu golf club");
        Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();
        clubBuilder.setCreateDate(timestamp);
        clubBuilder.setRank(3);

        ClubOuterClass.Club club = clubBuilder.build();

        ClubSerializeHandler clubSerializeHandler = new ClubSerializeHandler(myJedis);
        Assert.assertEquals(true, clubSerializeHandler.setToRedis(club));
        ClubOuterClass.Club clubFromRedis = clubSerializeHandler.getFromRedis(new String("club:1"));
        Assert.assertEquals(true, club.equals(clubFromRedis));

        myJedis.close();

    }
}
