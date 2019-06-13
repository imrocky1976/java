// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Club.proto

public final class ClubOuterClass {
  private ClubOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ClubOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Club)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <pre>
     * id
     * </pre>
     *
     * <code>uint64 id = 1;</code>
     */
    long getId();

    /**
     * <pre>
     * 名称
     * </pre>
     *
     * <code>string name = 2;</code>
     */
    java.lang.String getName();
    /**
     * <pre>
     * 名称
     * </pre>
     *
     * <code>string name = 2;</code>
     */
    com.google.protobuf.ByteString
        getNameBytes();

    /**
     * <pre>
     * 描述
     * </pre>
     *
     * <code>string info = 3;</code>
     */
    java.lang.String getInfo();
    /**
     * <pre>
     * 描述
     * </pre>
     *
     * <code>string info = 3;</code>
     */
    com.google.protobuf.ByteString
        getInfoBytes();

    /**
     * <pre>
     * 创建日期
     * </pre>
     *
     * <code>.google.protobuf.Timestamp createDate = 4;</code>
     */
    boolean hasCreateDate();
    /**
     * <pre>
     * 创建日期
     * </pre>
     *
     * <code>.google.protobuf.Timestamp createDate = 4;</code>
     */
    com.google.protobuf.Timestamp getCreateDate();
    /**
     * <pre>
     * 创建日期
     * </pre>
     *
     * <code>.google.protobuf.Timestamp createDate = 4;</code>
     */
    com.google.protobuf.TimestampOrBuilder getCreateDateOrBuilder();

    /**
     * <pre>
     *排名
     * </pre>
     *
     * <code>uint64 rank = 5;</code>
     */
    long getRank();
  }
  /**
   * Protobuf type {@code Club}
   */
  public  static final class Club extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Club)
      ClubOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Club.newBuilder() to construct.
    private Club(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Club() {
      id_ = 0L;
      name_ = "";
      info_ = "";
      rank_ = 0L;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Club(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              id_ = input.readUInt64();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              name_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              info_ = s;
              break;
            }
            case 34: {
              com.google.protobuf.Timestamp.Builder subBuilder = null;
              if (createDate_ != null) {
                subBuilder = createDate_.toBuilder();
              }
              createDate_ = input.readMessage(com.google.protobuf.Timestamp.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(createDate_);
                createDate_ = subBuilder.buildPartial();
              }

              break;
            }
            case 40: {

              rank_ = input.readUInt64();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ClubOuterClass.internal_static_Club_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ClubOuterClass.internal_static_Club_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ClubOuterClass.Club.class, ClubOuterClass.Club.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private long id_;
    /**
     * <pre>
     * id
     * </pre>
     *
     * <code>uint64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }

    public static final int NAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object name_;
    /**
     * <pre>
     * 名称
     * </pre>
     *
     * <code>string name = 2;</code>
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 名称
     * </pre>
     *
     * <code>string name = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int INFO_FIELD_NUMBER = 3;
    private volatile java.lang.Object info_;
    /**
     * <pre>
     * 描述
     * </pre>
     *
     * <code>string info = 3;</code>
     */
    public java.lang.String getInfo() {
      java.lang.Object ref = info_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        info_ = s;
        return s;
      }
    }
    /**
     * <pre>
     * 描述
     * </pre>
     *
     * <code>string info = 3;</code>
     */
    public com.google.protobuf.ByteString
        getInfoBytes() {
      java.lang.Object ref = info_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        info_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CREATEDATE_FIELD_NUMBER = 4;
    private com.google.protobuf.Timestamp createDate_;
    /**
     * <pre>
     * 创建日期
     * </pre>
     *
     * <code>.google.protobuf.Timestamp createDate = 4;</code>
     */
    public boolean hasCreateDate() {
      return createDate_ != null;
    }
    /**
     * <pre>
     * 创建日期
     * </pre>
     *
     * <code>.google.protobuf.Timestamp createDate = 4;</code>
     */
    public com.google.protobuf.Timestamp getCreateDate() {
      return createDate_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : createDate_;
    }
    /**
     * <pre>
     * 创建日期
     * </pre>
     *
     * <code>.google.protobuf.Timestamp createDate = 4;</code>
     */
    public com.google.protobuf.TimestampOrBuilder getCreateDateOrBuilder() {
      return getCreateDate();
    }

    public static final int RANK_FIELD_NUMBER = 5;
    private long rank_;
    /**
     * <pre>
     *排名
     * </pre>
     *
     * <code>uint64 rank = 5;</code>
     */
    public long getRank() {
      return rank_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (id_ != 0L) {
        output.writeUInt64(1, id_);
      }
      if (!getNameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
      }
      if (!getInfoBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, info_);
      }
      if (createDate_ != null) {
        output.writeMessage(4, getCreateDate());
      }
      if (rank_ != 0L) {
        output.writeUInt64(5, rank_);
      }
      unknownFields.writeTo(output);
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(1, id_);
      }
      if (!getNameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
      }
      if (!getInfoBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, info_);
      }
      if (createDate_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(4, getCreateDate());
      }
      if (rank_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(5, rank_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof ClubOuterClass.Club)) {
        return super.equals(obj);
      }
      ClubOuterClass.Club other = (ClubOuterClass.Club) obj;

      boolean result = true;
      result = result && (getId()
          == other.getId());
      result = result && getName()
          .equals(other.getName());
      result = result && getInfo()
          .equals(other.getInfo());
      result = result && (hasCreateDate() == other.hasCreateDate());
      if (hasCreateDate()) {
        result = result && getCreateDate()
            .equals(other.getCreateDate());
      }
      result = result && (getRank()
          == other.getRank());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getId());
      hash = (37 * hash) + NAME_FIELD_NUMBER;
      hash = (53 * hash) + getName().hashCode();
      hash = (37 * hash) + INFO_FIELD_NUMBER;
      hash = (53 * hash) + getInfo().hashCode();
      if (hasCreateDate()) {
        hash = (37 * hash) + CREATEDATE_FIELD_NUMBER;
        hash = (53 * hash) + getCreateDate().hashCode();
      }
      hash = (37 * hash) + RANK_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getRank());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ClubOuterClass.Club parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ClubOuterClass.Club parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ClubOuterClass.Club parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ClubOuterClass.Club parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ClubOuterClass.Club parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ClubOuterClass.Club parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ClubOuterClass.Club parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ClubOuterClass.Club parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ClubOuterClass.Club parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ClubOuterClass.Club parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ClubOuterClass.Club parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ClubOuterClass.Club parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ClubOuterClass.Club prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Club}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Club)
        ClubOuterClass.ClubOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ClubOuterClass.internal_static_Club_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ClubOuterClass.internal_static_Club_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ClubOuterClass.Club.class, ClubOuterClass.Club.Builder.class);
      }

      // Construct using ClubOuterClass.Club.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        id_ = 0L;

        name_ = "";

        info_ = "";

        if (createDateBuilder_ == null) {
          createDate_ = null;
        } else {
          createDate_ = null;
          createDateBuilder_ = null;
        }
        rank_ = 0L;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ClubOuterClass.internal_static_Club_descriptor;
      }

      public ClubOuterClass.Club getDefaultInstanceForType() {
        return ClubOuterClass.Club.getDefaultInstance();
      }

      public ClubOuterClass.Club build() {
        ClubOuterClass.Club result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ClubOuterClass.Club buildPartial() {
        ClubOuterClass.Club result = new ClubOuterClass.Club(this);
        result.id_ = id_;
        result.name_ = name_;
        result.info_ = info_;
        if (createDateBuilder_ == null) {
          result.createDate_ = createDate_;
        } else {
          result.createDate_ = createDateBuilder_.build();
        }
        result.rank_ = rank_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ClubOuterClass.Club) {
          return mergeFrom((ClubOuterClass.Club)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ClubOuterClass.Club other) {
        if (other == ClubOuterClass.Club.getDefaultInstance()) return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getName().isEmpty()) {
          name_ = other.name_;
          onChanged();
        }
        if (!other.getInfo().isEmpty()) {
          info_ = other.info_;
          onChanged();
        }
        if (other.hasCreateDate()) {
          mergeCreateDate(other.getCreateDate());
        }
        if (other.getRank() != 0L) {
          setRank(other.getRank());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ClubOuterClass.Club parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ClubOuterClass.Club) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long id_ ;
      /**
       * <pre>
       * id
       * </pre>
       *
       * <code>uint64 id = 1;</code>
       */
      public long getId() {
        return id_;
      }
      /**
       * <pre>
       * id
       * </pre>
       *
       * <code>uint64 id = 1;</code>
       */
      public Builder setId(long value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * id
       * </pre>
       *
       * <code>uint64 id = 1;</code>
       */
      public Builder clearId() {
        
        id_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object name_ = "";
      /**
       * <pre>
       * 名称
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          name_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * 名称
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public com.google.protobuf.ByteString
          getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          name_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 名称
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public Builder setName(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        name_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 名称
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public Builder clearName() {
        
        name_ = getDefaultInstance().getName();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 名称
       * </pre>
       *
       * <code>string name = 2;</code>
       */
      public Builder setNameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        name_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object info_ = "";
      /**
       * <pre>
       * 描述
       * </pre>
       *
       * <code>string info = 3;</code>
       */
      public java.lang.String getInfo() {
        java.lang.Object ref = info_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          info_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <pre>
       * 描述
       * </pre>
       *
       * <code>string info = 3;</code>
       */
      public com.google.protobuf.ByteString
          getInfoBytes() {
        java.lang.Object ref = info_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          info_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <pre>
       * 描述
       * </pre>
       *
       * <code>string info = 3;</code>
       */
      public Builder setInfo(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        info_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 描述
       * </pre>
       *
       * <code>string info = 3;</code>
       */
      public Builder clearInfo() {
        
        info_ = getDefaultInstance().getInfo();
        onChanged();
        return this;
      }
      /**
       * <pre>
       * 描述
       * </pre>
       *
       * <code>string info = 3;</code>
       */
      public Builder setInfoBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        info_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.Timestamp createDate_ = null;
      private com.google.protobuf.SingleFieldBuilderV3<
          com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> createDateBuilder_;
      /**
       * <pre>
       * 创建日期
       * </pre>
       *
       * <code>.google.protobuf.Timestamp createDate = 4;</code>
       */
      public boolean hasCreateDate() {
        return createDateBuilder_ != null || createDate_ != null;
      }
      /**
       * <pre>
       * 创建日期
       * </pre>
       *
       * <code>.google.protobuf.Timestamp createDate = 4;</code>
       */
      public com.google.protobuf.Timestamp getCreateDate() {
        if (createDateBuilder_ == null) {
          return createDate_ == null ? com.google.protobuf.Timestamp.getDefaultInstance() : createDate_;
        } else {
          return createDateBuilder_.getMessage();
        }
      }
      /**
       * <pre>
       * 创建日期
       * </pre>
       *
       * <code>.google.protobuf.Timestamp createDate = 4;</code>
       */
      public Builder setCreateDate(com.google.protobuf.Timestamp value) {
        if (createDateBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          createDate_ = value;
          onChanged();
        } else {
          createDateBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <pre>
       * 创建日期
       * </pre>
       *
       * <code>.google.protobuf.Timestamp createDate = 4;</code>
       */
      public Builder setCreateDate(
          com.google.protobuf.Timestamp.Builder builderForValue) {
        if (createDateBuilder_ == null) {
          createDate_ = builderForValue.build();
          onChanged();
        } else {
          createDateBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <pre>
       * 创建日期
       * </pre>
       *
       * <code>.google.protobuf.Timestamp createDate = 4;</code>
       */
      public Builder mergeCreateDate(com.google.protobuf.Timestamp value) {
        if (createDateBuilder_ == null) {
          if (createDate_ != null) {
            createDate_ =
              com.google.protobuf.Timestamp.newBuilder(createDate_).mergeFrom(value).buildPartial();
          } else {
            createDate_ = value;
          }
          onChanged();
        } else {
          createDateBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <pre>
       * 创建日期
       * </pre>
       *
       * <code>.google.protobuf.Timestamp createDate = 4;</code>
       */
      public Builder clearCreateDate() {
        if (createDateBuilder_ == null) {
          createDate_ = null;
          onChanged();
        } else {
          createDate_ = null;
          createDateBuilder_ = null;
        }

        return this;
      }
      /**
       * <pre>
       * 创建日期
       * </pre>
       *
       * <code>.google.protobuf.Timestamp createDate = 4;</code>
       */
      public com.google.protobuf.Timestamp.Builder getCreateDateBuilder() {
        
        onChanged();
        return getCreateDateFieldBuilder().getBuilder();
      }
      /**
       * <pre>
       * 创建日期
       * </pre>
       *
       * <code>.google.protobuf.Timestamp createDate = 4;</code>
       */
      public com.google.protobuf.TimestampOrBuilder getCreateDateOrBuilder() {
        if (createDateBuilder_ != null) {
          return createDateBuilder_.getMessageOrBuilder();
        } else {
          return createDate_ == null ?
              com.google.protobuf.Timestamp.getDefaultInstance() : createDate_;
        }
      }
      /**
       * <pre>
       * 创建日期
       * </pre>
       *
       * <code>.google.protobuf.Timestamp createDate = 4;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder> 
          getCreateDateFieldBuilder() {
        if (createDateBuilder_ == null) {
          createDateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              com.google.protobuf.Timestamp, com.google.protobuf.Timestamp.Builder, com.google.protobuf.TimestampOrBuilder>(
                  getCreateDate(),
                  getParentForChildren(),
                  isClean());
          createDate_ = null;
        }
        return createDateBuilder_;
      }

      private long rank_ ;
      /**
       * <pre>
       *排名
       * </pre>
       *
       * <code>uint64 rank = 5;</code>
       */
      public long getRank() {
        return rank_;
      }
      /**
       * <pre>
       *排名
       * </pre>
       *
       * <code>uint64 rank = 5;</code>
       */
      public Builder setRank(long value) {
        
        rank_ = value;
        onChanged();
        return this;
      }
      /**
       * <pre>
       *排名
       * </pre>
       *
       * <code>uint64 rank = 5;</code>
       */
      public Builder clearRank() {
        
        rank_ = 0L;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:Club)
    }

    // @@protoc_insertion_point(class_scope:Club)
    private static final ClubOuterClass.Club DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ClubOuterClass.Club();
    }

    public static ClubOuterClass.Club getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Club>
        PARSER = new com.google.protobuf.AbstractParser<Club>() {
      public Club parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Club(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Club> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Club> getParserForType() {
      return PARSER;
    }

    public ClubOuterClass.Club getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Club_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Club_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nClub.proto\032\037google/protobuf/timestamp." +
      "proto\"l\n\004Club\022\n\n\002id\030\001 \001(\004\022\014\n\004name\030\002 \001(\t\022" +
      "\014\n\004info\030\003 \001(\t\022.\n\ncreateDate\030\004 \001(\0132\032.goog" +
      "le.protobuf.Timestamp\022\014\n\004rank\030\005 \001(\004b\006pro" +
      "to3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        }, assigner);
    internal_static_Club_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Club_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Club_descriptor,
        new java.lang.String[] { "Id", "Name", "Info", "CreateDate", "Rank", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
