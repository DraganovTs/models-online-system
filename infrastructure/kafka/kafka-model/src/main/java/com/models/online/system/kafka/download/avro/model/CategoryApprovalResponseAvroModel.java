/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.models.online.system.kafka.download.avro.model;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class CategoryApprovalResponseAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8072036265467089147L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CategoryApprovalResponseAvroModel\",\"namespace\":\"com.models.online.system.kafka.download.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"categoryId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"downloadId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"downloadApprovalStatus\",\"type\":{\"type\":\"enum\",\"name\":\"DownloadApprovalStatus\",\"symbols\":[\"APPROVED\",\"REJECTED\"]}},{\"name\":\"failureMessages\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<CategoryApprovalResponseAvroModel> ENCODER =
      new BinaryMessageEncoder<CategoryApprovalResponseAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CategoryApprovalResponseAvroModel> DECODER =
      new BinaryMessageDecoder<CategoryApprovalResponseAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CategoryApprovalResponseAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CategoryApprovalResponseAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CategoryApprovalResponseAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CategoryApprovalResponseAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CategoryApprovalResponseAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CategoryApprovalResponseAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CategoryApprovalResponseAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CategoryApprovalResponseAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String sagaId;
  private java.lang.String categoryId;
  private java.lang.String downloadId;
  private java.time.Instant createdAt;
  private com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus downloadApprovalStatus;
  private java.util.List<java.lang.String> failureMessages;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CategoryApprovalResponseAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param categoryId The new value for categoryId
   * @param downloadId The new value for downloadId
   * @param createdAt The new value for createdAt
   * @param downloadApprovalStatus The new value for downloadApprovalStatus
   * @param failureMessages The new value for failureMessages
   */
  public CategoryApprovalResponseAvroModel(java.lang.String id, java.lang.String sagaId, java.lang.String categoryId, java.lang.String downloadId, java.time.Instant createdAt, com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus downloadApprovalStatus, java.util.List<java.lang.String> failureMessages) {
    this.id = id;
    this.sagaId = sagaId;
    this.categoryId = categoryId;
    this.downloadId = downloadId;
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.downloadApprovalStatus = downloadApprovalStatus;
    this.failureMessages = failureMessages;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return sagaId;
    case 2: return categoryId;
    case 3: return downloadId;
    case 4: return createdAt;
    case 5: return downloadApprovalStatus;
    case 6: return failureMessages;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = value$ != null ? value$.toString() : null; break;
    case 1: sagaId = value$ != null ? value$.toString() : null; break;
    case 2: categoryId = value$ != null ? value$.toString() : null; break;
    case 3: downloadId = value$ != null ? value$.toString() : null; break;
    case 4: createdAt = (java.time.Instant)value$; break;
    case 5: downloadApprovalStatus = (com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus)value$; break;
    case 6: failureMessages = (java.util.List<java.lang.String>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.String getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.String value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'sagaId' field.
   * @return The value of the 'sagaId' field.
   */
  public java.lang.String getSagaId() {
    return sagaId;
  }


  /**
   * Sets the value of the 'sagaId' field.
   * @param value the value to set.
   */
  public void setSagaId(java.lang.String value) {
    this.sagaId = value;
  }

  /**
   * Gets the value of the 'categoryId' field.
   * @return The value of the 'categoryId' field.
   */
  public java.lang.String getCategoryId() {
    return categoryId;
  }


  /**
   * Sets the value of the 'categoryId' field.
   * @param value the value to set.
   */
  public void setCategoryId(java.lang.String value) {
    this.categoryId = value;
  }

  /**
   * Gets the value of the 'downloadId' field.
   * @return The value of the 'downloadId' field.
   */
  public java.lang.String getDownloadId() {
    return downloadId;
  }


  /**
   * Sets the value of the 'downloadId' field.
   * @param value the value to set.
   */
  public void setDownloadId(java.lang.String value) {
    this.downloadId = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   * @return The value of the 'createdAt' field.
   */
  public java.time.Instant getCreatedAt() {
    return createdAt;
  }


  /**
   * Sets the value of the 'createdAt' field.
   * @param value the value to set.
   */
  public void setCreatedAt(java.time.Instant value) {
    this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'downloadApprovalStatus' field.
   * @return The value of the 'downloadApprovalStatus' field.
   */
  public com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus getDownloadApprovalStatus() {
    return downloadApprovalStatus;
  }


  /**
   * Sets the value of the 'downloadApprovalStatus' field.
   * @param value the value to set.
   */
  public void setDownloadApprovalStatus(com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus value) {
    this.downloadApprovalStatus = value;
  }

  /**
   * Gets the value of the 'failureMessages' field.
   * @return The value of the 'failureMessages' field.
   */
  public java.util.List<java.lang.String> getFailureMessages() {
    return failureMessages;
  }


  /**
   * Sets the value of the 'failureMessages' field.
   * @param value the value to set.
   */
  public void setFailureMessages(java.util.List<java.lang.String> value) {
    this.failureMessages = value;
  }

  /**
   * Creates a new CategoryApprovalResponseAvroModel RecordBuilder.
   * @return A new CategoryApprovalResponseAvroModel RecordBuilder
   */
  public static com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder newBuilder() {
    return new com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder();
  }

  /**
   * Creates a new CategoryApprovalResponseAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CategoryApprovalResponseAvroModel RecordBuilder
   */
  public static com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder newBuilder(com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder other) {
    if (other == null) {
      return new com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder();
    } else {
      return new com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new CategoryApprovalResponseAvroModel RecordBuilder by copying an existing CategoryApprovalResponseAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new CategoryApprovalResponseAvroModel RecordBuilder
   */
  public static com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder newBuilder(com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel other) {
    if (other == null) {
      return new com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder();
    } else {
      return new com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for CategoryApprovalResponseAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CategoryApprovalResponseAvroModel>
    implements org.apache.avro.data.RecordBuilder<CategoryApprovalResponseAvroModel> {

    private java.lang.String id;
    private java.lang.String sagaId;
    private java.lang.String categoryId;
    private java.lang.String downloadId;
    private java.time.Instant createdAt;
    private com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus downloadApprovalStatus;
    private java.util.List<java.lang.String> failureMessages;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.categoryId)) {
        this.categoryId = data().deepCopy(fields()[2].schema(), other.categoryId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.downloadId)) {
        this.downloadId = data().deepCopy(fields()[3].schema(), other.downloadId);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.downloadApprovalStatus)) {
        this.downloadApprovalStatus = data().deepCopy(fields()[5].schema(), other.downloadApprovalStatus);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.failureMessages)) {
        this.failureMessages = data().deepCopy(fields()[6].schema(), other.failureMessages);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing CategoryApprovalResponseAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.categoryId)) {
        this.categoryId = data().deepCopy(fields()[2].schema(), other.categoryId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.downloadId)) {
        this.downloadId = data().deepCopy(fields()[3].schema(), other.downloadId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.downloadApprovalStatus)) {
        this.downloadApprovalStatus = data().deepCopy(fields()[5].schema(), other.downloadApprovalStatus);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.failureMessages)) {
        this.failureMessages = data().deepCopy(fields()[6].schema(), other.failureMessages);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.String getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder setId(java.lang.String value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'sagaId' field.
      * @return The value.
      */
    public java.lang.String getSagaId() {
      return sagaId;
    }


    /**
      * Sets the value of the 'sagaId' field.
      * @param value The value of 'sagaId'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder setSagaId(java.lang.String value) {
      validate(fields()[1], value);
      this.sagaId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'sagaId' field has been set.
      * @return True if the 'sagaId' field has been set, false otherwise.
      */
    public boolean hasSagaId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'sagaId' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder clearSagaId() {
      sagaId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'categoryId' field.
      * @return The value.
      */
    public java.lang.String getCategoryId() {
      return categoryId;
    }


    /**
      * Sets the value of the 'categoryId' field.
      * @param value The value of 'categoryId'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder setCategoryId(java.lang.String value) {
      validate(fields()[2], value);
      this.categoryId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'categoryId' field has been set.
      * @return True if the 'categoryId' field has been set, false otherwise.
      */
    public boolean hasCategoryId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'categoryId' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder clearCategoryId() {
      categoryId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'downloadId' field.
      * @return The value.
      */
    public java.lang.String getDownloadId() {
      return downloadId;
    }


    /**
      * Sets the value of the 'downloadId' field.
      * @param value The value of 'downloadId'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder setDownloadId(java.lang.String value) {
      validate(fields()[3], value);
      this.downloadId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'downloadId' field has been set.
      * @return True if the 'downloadId' field has been set, false otherwise.
      */
    public boolean hasDownloadId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'downloadId' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder clearDownloadId() {
      downloadId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'createdAt' field.
      * @return The value.
      */
    public java.time.Instant getCreatedAt() {
      return createdAt;
    }


    /**
      * Sets the value of the 'createdAt' field.
      * @param value The value of 'createdAt'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder setCreatedAt(java.time.Instant value) {
      validate(fields()[4], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder clearCreatedAt() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'downloadApprovalStatus' field.
      * @return The value.
      */
    public com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus getDownloadApprovalStatus() {
      return downloadApprovalStatus;
    }


    /**
      * Sets the value of the 'downloadApprovalStatus' field.
      * @param value The value of 'downloadApprovalStatus'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder setDownloadApprovalStatus(com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus value) {
      validate(fields()[5], value);
      this.downloadApprovalStatus = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'downloadApprovalStatus' field has been set.
      * @return True if the 'downloadApprovalStatus' field has been set, false otherwise.
      */
    public boolean hasDownloadApprovalStatus() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'downloadApprovalStatus' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder clearDownloadApprovalStatus() {
      downloadApprovalStatus = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'failureMessages' field.
      * @return The value.
      */
    public java.util.List<java.lang.String> getFailureMessages() {
      return failureMessages;
    }


    /**
      * Sets the value of the 'failureMessages' field.
      * @param value The value of 'failureMessages'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder setFailureMessages(java.util.List<java.lang.String> value) {
      validate(fields()[6], value);
      this.failureMessages = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'failureMessages' field has been set.
      * @return True if the 'failureMessages' field has been set, false otherwise.
      */
    public boolean hasFailureMessages() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'failureMessages' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalResponseAvroModel.Builder clearFailureMessages() {
      failureMessages = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CategoryApprovalResponseAvroModel build() {
      try {
        CategoryApprovalResponseAvroModel record = new CategoryApprovalResponseAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.sagaId = fieldSetFlags()[1] ? this.sagaId : (java.lang.String) defaultValue(fields()[1]);
        record.categoryId = fieldSetFlags()[2] ? this.categoryId : (java.lang.String) defaultValue(fields()[2]);
        record.downloadId = fieldSetFlags()[3] ? this.downloadId : (java.lang.String) defaultValue(fields()[3]);
        record.createdAt = fieldSetFlags()[4] ? this.createdAt : (java.time.Instant) defaultValue(fields()[4]);
        record.downloadApprovalStatus = fieldSetFlags()[5] ? this.downloadApprovalStatus : (com.models.online.system.kafka.download.avro.model.DownloadApprovalStatus) defaultValue(fields()[5]);
        record.failureMessages = fieldSetFlags()[6] ? this.failureMessages : (java.util.List<java.lang.String>) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CategoryApprovalResponseAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<CategoryApprovalResponseAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CategoryApprovalResponseAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<CategoryApprovalResponseAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










