package netty.appFramework.netty.proto;
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ProtofulRequeset.proto

public final class ProtoRequest {
  private ProtoRequest() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface RequestOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Request)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional .TestBuf test = 1;</code>
     */
    ProtoRequest.TestBuf getTest();
    /**
     * <code>optional .TestBuf test = 1;</code>
     */
    ProtoRequest.TestBufOrBuilder getTestOrBuilder();

    public ProtoRequest.Request.CommandCase getCommandCase();
  }
  /**
   * Protobuf type {@code Request}
   */
  public  static final class Request extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:Request)
      RequestOrBuilder {
    // Use Request.newBuilder() to construct.
    private Request(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private Request() {
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Request(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              ProtoRequest.TestBuf.Builder subBuilder = null;
              if (commandCase_ == 1) {
                subBuilder = ((ProtoRequest.TestBuf) command_).toBuilder();
              }
              command_ =
                  input.readMessage(ProtoRequest.TestBuf.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom((ProtoRequest.TestBuf) command_);
                command_ = subBuilder.buildPartial();
              }
              commandCase_ = 1;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw new RuntimeException(e.setUnfinishedMessage(this));
      } catch (java.io.IOException e) {
        throw new RuntimeException(
            new com.google.protobuf.InvalidProtocolBufferException(
                e.getMessage()).setUnfinishedMessage(this));
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ProtoRequest.internal_static_Request_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ProtoRequest.internal_static_Request_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ProtoRequest.Request.class, ProtoRequest.Request.Builder.class);
    }

    private int commandCase_ = 0;
    private java.lang.Object command_;
    public enum CommandCase
        implements com.google.protobuf.Internal.EnumLite {
      TEST(1),
      COMMAND_NOT_SET(0);
      private int value = 0;
      private CommandCase(int value) {
        this.value = value;
      }
      public static CommandCase valueOf(int value) {
        switch (value) {
          case 1: return TEST;
          case 0: return COMMAND_NOT_SET;
          default: throw new java.lang.IllegalArgumentException(
            "Value is undefined for this oneof enum.");
        }
      }
      public int getNumber() {
        return this.value;
      }
    };

    public CommandCase
    getCommandCase() {
      return CommandCase.valueOf(
          commandCase_);
    }

    public static final int TEST_FIELD_NUMBER = 1;
    /**
     * <code>optional .TestBuf test = 1;</code>
     */
    public ProtoRequest.TestBuf getTest() {
      if (commandCase_ == 1) {
         return (ProtoRequest.TestBuf) command_;
      }
      return ProtoRequest.TestBuf.getDefaultInstance();
    }
    /**
     * <code>optional .TestBuf test = 1;</code>
     */
    public ProtoRequest.TestBufOrBuilder getTestOrBuilder() {
      if (commandCase_ == 1) {
         return (ProtoRequest.TestBuf) command_;
      }
      return ProtoRequest.TestBuf.getDefaultInstance();
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
      if (commandCase_ == 1) {
        output.writeMessage(1, (ProtoRequest.TestBuf) command_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (commandCase_ == 1) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, (ProtoRequest.TestBuf) command_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static ProtoRequest.Request parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ProtoRequest.Request parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ProtoRequest.Request parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ProtoRequest.Request parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ProtoRequest.Request parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ProtoRequest.Request parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static ProtoRequest.Request parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static ProtoRequest.Request parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static ProtoRequest.Request parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ProtoRequest.Request parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ProtoRequest.Request prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code Request}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Request)
        ProtoRequest.RequestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ProtoRequest.internal_static_Request_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ProtoRequest.internal_static_Request_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ProtoRequest.Request.class, ProtoRequest.Request.Builder.class);
      }

      // Construct using ProtoRequest.Request.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        commandCase_ = 0;
        command_ = null;
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ProtoRequest.internal_static_Request_descriptor;
      }

      public ProtoRequest.Request getDefaultInstanceForType() {
        return ProtoRequest.Request.getDefaultInstance();
      }

      public ProtoRequest.Request build() {
        ProtoRequest.Request result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ProtoRequest.Request buildPartial() {
        ProtoRequest.Request result = new ProtoRequest.Request(this);
        if (commandCase_ == 1) {
          if (testBuilder_ == null) {
            result.command_ = command_;
          } else {
            result.command_ = testBuilder_.build();
          }
        }
        result.commandCase_ = commandCase_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ProtoRequest.Request) {
          return mergeFrom((ProtoRequest.Request)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ProtoRequest.Request other) {
        if (other == ProtoRequest.Request.getDefaultInstance()) return this;
        switch (other.getCommandCase()) {
          case TEST: {
            mergeTest(other.getTest());
            break;
          }
          case COMMAND_NOT_SET: {
            break;
          }
        }
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
        ProtoRequest.Request parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ProtoRequest.Request) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int commandCase_ = 0;
      private java.lang.Object command_;
      public CommandCase
          getCommandCase() {
        return CommandCase.valueOf(
            commandCase_);
      }

      public Builder clearCommand() {
        commandCase_ = 0;
        command_ = null;
        onChanged();
        return this;
      }


      private com.google.protobuf.SingleFieldBuilder<
          ProtoRequest.TestBuf, ProtoRequest.TestBuf.Builder, ProtoRequest.TestBufOrBuilder> testBuilder_;
      /**
       * <code>optional .TestBuf test = 1;</code>
       */
      public ProtoRequest.TestBuf getTest() {
        if (testBuilder_ == null) {
          if (commandCase_ == 1) {
            return (ProtoRequest.TestBuf) command_;
          }
          return ProtoRequest.TestBuf.getDefaultInstance();
        } else {
          if (commandCase_ == 1) {
            return testBuilder_.getMessage();
          }
          return ProtoRequest.TestBuf.getDefaultInstance();
        }
      }
      /**
       * <code>optional .TestBuf test = 1;</code>
       */
      public Builder setTest(ProtoRequest.TestBuf value) {
        if (testBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          command_ = value;
          onChanged();
        } else {
          testBuilder_.setMessage(value);
        }
        commandCase_ = 1;
        return this;
      }
      /**
       * <code>optional .TestBuf test = 1;</code>
       */
      public Builder setTest(
          ProtoRequest.TestBuf.Builder builderForValue) {
        if (testBuilder_ == null) {
          command_ = builderForValue.build();
          onChanged();
        } else {
          testBuilder_.setMessage(builderForValue.build());
        }
        commandCase_ = 1;
        return this;
      }
      /**
       * <code>optional .TestBuf test = 1;</code>
       */
      public Builder mergeTest(ProtoRequest.TestBuf value) {
        if (testBuilder_ == null) {
          if (commandCase_ == 1 &&
              command_ != ProtoRequest.TestBuf.getDefaultInstance()) {
            command_ = ProtoRequest.TestBuf.newBuilder((ProtoRequest.TestBuf) command_)
                .mergeFrom(value).buildPartial();
          } else {
            command_ = value;
          }
          onChanged();
        } else {
          if (commandCase_ == 1) {
            testBuilder_.mergeFrom(value);
          }
          testBuilder_.setMessage(value);
        }
        commandCase_ = 1;
        return this;
      }
      /**
       * <code>optional .TestBuf test = 1;</code>
       */
      public Builder clearTest() {
        if (testBuilder_ == null) {
          if (commandCase_ == 1) {
            commandCase_ = 0;
            command_ = null;
            onChanged();
          }
        } else {
          if (commandCase_ == 1) {
            commandCase_ = 0;
            command_ = null;
          }
          testBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>optional .TestBuf test = 1;</code>
       */
      public ProtoRequest.TestBuf.Builder getTestBuilder() {
        return getTestFieldBuilder().getBuilder();
      }
      /**
       * <code>optional .TestBuf test = 1;</code>
       */
      public ProtoRequest.TestBufOrBuilder getTestOrBuilder() {
        if ((commandCase_ == 1) && (testBuilder_ != null)) {
          return testBuilder_.getMessageOrBuilder();
        } else {
          if (commandCase_ == 1) {
            return (ProtoRequest.TestBuf) command_;
          }
          return ProtoRequest.TestBuf.getDefaultInstance();
        }
      }
      /**
       * <code>optional .TestBuf test = 1;</code>
       */
      private com.google.protobuf.SingleFieldBuilder<
          ProtoRequest.TestBuf, ProtoRequest.TestBuf.Builder, ProtoRequest.TestBufOrBuilder> 
          getTestFieldBuilder() {
        if (testBuilder_ == null) {
          if (!(commandCase_ == 1)) {
            command_ = ProtoRequest.TestBuf.getDefaultInstance();
          }
          testBuilder_ = new com.google.protobuf.SingleFieldBuilder<
              ProtoRequest.TestBuf, ProtoRequest.TestBuf.Builder, ProtoRequest.TestBufOrBuilder>(
                  (ProtoRequest.TestBuf) command_,
                  getParentForChildren(),
                  isClean());
          command_ = null;
        }
        commandCase_ = 1;
        onChanged();;
        return testBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:Request)
    }

    // @@protoc_insertion_point(class_scope:Request)
    private static final ProtoRequest.Request DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ProtoRequest.Request();
    }

    public static ProtoRequest.Request getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Request>
        PARSER = new com.google.protobuf.AbstractParser<Request>() {
      public Request parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        try {
          return new Request(input, extensionRegistry);
        } catch (RuntimeException e) {
          if (e.getCause() instanceof
              com.google.protobuf.InvalidProtocolBufferException) {
            throw (com.google.protobuf.InvalidProtocolBufferException)
                e.getCause();
          }
          throw e;
        }
      }
    };

    public static com.google.protobuf.Parser<Request> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Request> getParserForType() {
      return PARSER;
    }

    public ProtoRequest.Request getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface TestBufOrBuilder extends
      // @@protoc_insertion_point(interface_extends:TestBuf)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string data = 1;</code>
     */
    java.lang.String getData();
    /**
     * <code>optional string data = 1;</code>
     */
    com.google.protobuf.ByteString
        getDataBytes();
  }
  /**
   * Protobuf type {@code TestBuf}
   */
  public  static final class TestBuf extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:TestBuf)
      TestBufOrBuilder {
    // Use TestBuf.newBuilder() to construct.
    private TestBuf(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
    }
    private TestBuf() {
      data_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private TestBuf(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry) {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              data_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw new RuntimeException(e.setUnfinishedMessage(this));
      } catch (java.io.IOException e) {
        throw new RuntimeException(
            new com.google.protobuf.InvalidProtocolBufferException(
                e.getMessage()).setUnfinishedMessage(this));
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ProtoRequest.internal_static_TestBuf_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ProtoRequest.internal_static_TestBuf_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ProtoRequest.TestBuf.class, ProtoRequest.TestBuf.Builder.class);
    }

    public static final int DATA_FIELD_NUMBER = 1;
    private volatile java.lang.Object data_;
    /**
     * <code>optional string data = 1;</code>
     */
    public java.lang.String getData() {
      java.lang.Object ref = data_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        data_ = s;
        return s;
      }
    }
    /**
     * <code>optional string data = 1;</code>
     */
    public com.google.protobuf.ByteString
        getDataBytes() {
      java.lang.Object ref = data_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        data_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
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
      if (!getDataBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessage.writeString(output, 1, data_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getDataBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessage.computeStringSize(1, data_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    public static ProtoRequest.TestBuf parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ProtoRequest.TestBuf parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ProtoRequest.TestBuf parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ProtoRequest.TestBuf parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ProtoRequest.TestBuf parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ProtoRequest.TestBuf parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static ProtoRequest.TestBuf parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static ProtoRequest.TestBuf parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static ProtoRequest.TestBuf parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ProtoRequest.TestBuf parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ProtoRequest.TestBuf prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code TestBuf}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:TestBuf)
        ProtoRequest.TestBufOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ProtoRequest.internal_static_TestBuf_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ProtoRequest.internal_static_TestBuf_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ProtoRequest.TestBuf.class, ProtoRequest.TestBuf.Builder.class);
      }

      // Construct using ProtoRequest.TestBuf.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        data_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ProtoRequest.internal_static_TestBuf_descriptor;
      }

      public ProtoRequest.TestBuf getDefaultInstanceForType() {
        return ProtoRequest.TestBuf.getDefaultInstance();
      }

      public ProtoRequest.TestBuf build() {
        ProtoRequest.TestBuf result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ProtoRequest.TestBuf buildPartial() {
        ProtoRequest.TestBuf result = new ProtoRequest.TestBuf(this);
        result.data_ = data_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ProtoRequest.TestBuf) {
          return mergeFrom((ProtoRequest.TestBuf)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ProtoRequest.TestBuf other) {
        if (other == ProtoRequest.TestBuf.getDefaultInstance()) return this;
        if (!other.getData().isEmpty()) {
          data_ = other.data_;
          onChanged();
        }
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
        ProtoRequest.TestBuf parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ProtoRequest.TestBuf) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object data_ = "";
      /**
       * <code>optional string data = 1;</code>
       */
      public java.lang.String getData() {
        java.lang.Object ref = data_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          data_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string data = 1;</code>
       */
      public com.google.protobuf.ByteString
          getDataBytes() {
        java.lang.Object ref = data_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          data_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string data = 1;</code>
       */
      public Builder setData(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string data = 1;</code>
       */
      public Builder clearData() {
        
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }
      /**
       * <code>optional string data = 1;</code>
       */
      public Builder setDataBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        data_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:TestBuf)
    }

    // @@protoc_insertion_point(class_scope:TestBuf)
    private static final ProtoRequest.TestBuf DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ProtoRequest.TestBuf();
    }

    public static ProtoRequest.TestBuf getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<TestBuf>
        PARSER = new com.google.protobuf.AbstractParser<TestBuf>() {
      public TestBuf parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        try {
          return new TestBuf(input, extensionRegistry);
        } catch (RuntimeException e) {
          if (e.getCause() instanceof
              com.google.protobuf.InvalidProtocolBufferException) {
            throw (com.google.protobuf.InvalidProtocolBufferException)
                e.getCause();
          }
          throw e;
        }
      }
    };

    public static com.google.protobuf.Parser<TestBuf> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<TestBuf> getParserForType() {
      return PARSER;
    }

    public ProtoRequest.TestBuf getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_Request_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_Request_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_TestBuf_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_TestBuf_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026ProtofulRequeset.proto\".\n\007Request\022\030\n\004t" +
      "est\030\001 \001(\0132\010.TestBufH\000B\t\n\007Command\"\027\n\007Test" +
      "Buf\022\014\n\004data\030\001 \001(\tB\016B\014ProtoRequestb\006proto" +
      "3"
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
        }, assigner);
    internal_static_Request_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_Request_descriptor,
        new java.lang.String[] { "Test", "Command", });
    internal_static_TestBuf_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_TestBuf_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_TestBuf_descriptor,
        new java.lang.String[] { "Data", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
