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
public class CategoryApprovalRequestAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6272104773809624481L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"CategoryApprovalRequestAvroModel\",\"namespace\":\"com.models.online.system.kafka.download.avro.model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"categoryId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"downloadId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"categoryDownloadStatus\",\"type\":{\"type\":\"enum\",\"name\":\"CategoryDownloadStatus\",\"symbols\":[\"PAID\"]}},{\"name\":\"models\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Model\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"logicalType\":\"uuid\"}]}}},{\"name\":\"price\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();
  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<CategoryApprovalRequestAvroModel> ENCODER =
      new BinaryMessageEncoder<CategoryApprovalRequestAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<CategoryApprovalRequestAvroModel> DECODER =
      new BinaryMessageDecoder<CategoryApprovalRequestAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<CategoryApprovalRequestAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<CategoryApprovalRequestAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<CategoryApprovalRequestAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<CategoryApprovalRequestAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this CategoryApprovalRequestAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a CategoryApprovalRequestAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a CategoryApprovalRequestAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static CategoryApprovalRequestAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.String id;
  private java.lang.String sagaId;
  private java.lang.String categoryId;
  private java.lang.String downloadId;
  private com.models.online.system.kafka.download.avro.model.CategoryDownloadStatus categoryDownloadStatus;
  private java.util.List<com.models.online.system.kafka.download.avro.model.Model> models;
  private java.math.BigDecimal price;
  private java.time.Instant createdAt;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public CategoryApprovalRequestAvroModel() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param categoryId The new value for categoryId
   * @param downloadId The new value for downloadId
   * @param categoryDownloadStatus The new value for categoryDownloadStatus
   * @param models The new value for models
   * @param price The new value for price
   * @param createdAt The new value for createdAt
   */
  public CategoryApprovalRequestAvroModel(java.lang.String id, java.lang.String sagaId, java.lang.String categoryId, java.lang.String downloadId, com.models.online.system.kafka.download.avro.model.CategoryDownloadStatus categoryDownloadStatus, java.util.List<com.models.online.system.kafka.download.avro.model.Model> models, java.math.BigDecimal price, java.time.Instant createdAt) {
    this.id = id;
    this.sagaId = sagaId;
    this.categoryId = categoryId;
    this.downloadId = downloadId;
    this.categoryDownloadStatus = categoryDownloadStatus;
    this.models = models;
    this.price = price;
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
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
    case 4: return categoryDownloadStatus;
    case 5: return models;
    case 6: return price;
    case 7: return createdAt;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      null,
      null,
      null,
      null,
      null,
      null,
      new org.apache.avro.Conversions.DecimalConversion(),
      new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
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
    case 4: categoryDownloadStatus = (com.models.online.system.kafka.download.avro.model.CategoryDownloadStatus)value$; break;
    case 5: models = (java.util.List<com.models.online.system.kafka.download.avro.model.Model>)value$; break;
    case 6: price = (java.math.BigDecimal)value$; break;
    case 7: createdAt = (java.time.Instant)value$; break;
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
   * Gets the value of the 'categoryDownloadStatus' field.
   * @return The value of the 'categoryDownloadStatus' field.
   */
  public com.models.online.system.kafka.download.avro.model.CategoryDownloadStatus getCategoryDownloadStatus() {
    return categoryDownloadStatus;
  }


  /**
   * Sets the value of the 'categoryDownloadStatus' field.
   * @param value the value to set.
   */
  public void setCategoryDownloadStatus(com.models.online.system.kafka.download.avro.model.CategoryDownloadStatus value) {
    this.categoryDownloadStatus = value;
  }

  /**
   * Gets the value of the 'models' field.
   * @return The value of the 'models' field.
   */
  public java.util.List<com.models.online.system.kafka.download.avro.model.Model> getModels() {
    return models;
  }


  /**
   * Sets the value of the 'models' field.
   * @param value the value to set.
   */
  public void setModels(java.util.List<com.models.online.system.kafka.download.avro.model.Model> value) {
    this.models = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public java.math.BigDecimal getPrice() {
    return price;
  }


  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(java.math.BigDecimal value) {
    this.price = value;
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
   * Creates a new CategoryApprovalRequestAvroModel RecordBuilder.
   * @return A new CategoryApprovalRequestAvroModel RecordBuilder
   */
  public static com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder newBuilder() {
    return new com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder();
  }

  /**
   * Creates a new CategoryApprovalRequestAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new CategoryApprovalRequestAvroModel RecordBuilder
   */
  public static com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder newBuilder(com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder other) {
    if (other == null) {
      return new com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder();
    } else {
      return new com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new CategoryApprovalRequestAvroModel RecordBuilder by copying an existing CategoryApprovalRequestAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new CategoryApprovalRequestAvroModel RecordBuilder
   */
  public static com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder newBuilder(com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel other) {
    if (other == null) {
      return new com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder();
    } else {
      return new com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder(other);
    }
  }

  /**
   * RecordBuilder for CategoryApprovalRequestAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<CategoryApprovalRequestAvroModel>
    implements org.apache.avro.data.RecordBuilder<CategoryApprovalRequestAvroModel> {

    private java.lang.String id;
    private java.lang.String sagaId;
    private java.lang.String categoryId;
    private java.lang.String downloadId;
    private com.models.online.system.kafka.download.avro.model.CategoryDownloadStatus categoryDownloadStatus;
    private java.util.List<com.models.online.system.kafka.download.avro.model.Model> models;
    private java.math.BigDecimal price;
    private java.time.Instant createdAt;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder other) {
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
      if (isValidValue(fields()[4], other.categoryDownloadStatus)) {
        this.categoryDownloadStatus = data().deepCopy(fields()[4].schema(), other.categoryDownloadStatus);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.models)) {
        this.models = data().deepCopy(fields()[5].schema(), other.models);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.price)) {
        this.price = data().deepCopy(fields()[6].schema(), other.price);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
      if (isValidValue(fields()[7], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[7].schema(), other.createdAt);
        fieldSetFlags()[7] = other.fieldSetFlags()[7];
      }
    }

    /**
     * Creates a Builder by copying an existing CategoryApprovalRequestAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel other) {
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
      if (isValidValue(fields()[4], other.categoryDownloadStatus)) {
        this.categoryDownloadStatus = data().deepCopy(fields()[4].schema(), other.categoryDownloadStatus);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.models)) {
        this.models = data().deepCopy(fields()[5].schema(), other.models);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.price)) {
        this.price = data().deepCopy(fields()[6].schema(), other.price);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[7].schema(), other.createdAt);
        fieldSetFlags()[7] = true;
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
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder setId(java.lang.String value) {
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
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder clearId() {
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
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder setSagaId(java.lang.String value) {
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
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder clearSagaId() {
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
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder setCategoryId(java.lang.String value) {
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
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder clearCategoryId() {
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
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder setDownloadId(java.lang.String value) {
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
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder clearDownloadId() {
      downloadId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'categoryDownloadStatus' field.
      * @return The value.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryDownloadStatus getCategoryDownloadStatus() {
      return categoryDownloadStatus;
    }


    /**
      * Sets the value of the 'categoryDownloadStatus' field.
      * @param value The value of 'categoryDownloadStatus'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder setCategoryDownloadStatus(com.models.online.system.kafka.download.avro.model.CategoryDownloadStatus value) {
      validate(fields()[4], value);
      this.categoryDownloadStatus = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'categoryDownloadStatus' field has been set.
      * @return True if the 'categoryDownloadStatus' field has been set, false otherwise.
      */
    public boolean hasCategoryDownloadStatus() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'categoryDownloadStatus' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder clearCategoryDownloadStatus() {
      categoryDownloadStatus = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'models' field.
      * @return The value.
      */
    public java.util.List<com.models.online.system.kafka.download.avro.model.Model> getModels() {
      return models;
    }


    /**
      * Sets the value of the 'models' field.
      * @param value The value of 'models'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder setModels(java.util.List<com.models.online.system.kafka.download.avro.model.Model> value) {
      validate(fields()[5], value);
      this.models = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'models' field has been set.
      * @return True if the 'models' field has been set, false otherwise.
      */
    public boolean hasModels() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'models' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder clearModels() {
      models = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.math.BigDecimal getPrice() {
      return price;
    }


    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder setPrice(java.math.BigDecimal value) {
      validate(fields()[6], value);
      this.price = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder clearPrice() {
      price = null;
      fieldSetFlags()[6] = false;
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
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder setCreatedAt(java.time.Instant value) {
      validate(fields()[7], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'createdAt' field has been set.
      * @return True if the 'createdAt' field has been set, false otherwise.
      */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'createdAt' field.
      * @return This builder.
      */
    public com.models.online.system.kafka.download.avro.model.CategoryApprovalRequestAvroModel.Builder clearCreatedAt() {
      fieldSetFlags()[7] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public CategoryApprovalRequestAvroModel build() {
      try {
        CategoryApprovalRequestAvroModel record = new CategoryApprovalRequestAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.String) defaultValue(fields()[0]);
        record.sagaId = fieldSetFlags()[1] ? this.sagaId : (java.lang.String) defaultValue(fields()[1]);
        record.categoryId = fieldSetFlags()[2] ? this.categoryId : (java.lang.String) defaultValue(fields()[2]);
        record.downloadId = fieldSetFlags()[3] ? this.downloadId : (java.lang.String) defaultValue(fields()[3]);
        record.categoryDownloadStatus = fieldSetFlags()[4] ? this.categoryDownloadStatus : (com.models.online.system.kafka.download.avro.model.CategoryDownloadStatus) defaultValue(fields()[4]);
        record.models = fieldSetFlags()[5] ? this.models : (java.util.List<com.models.online.system.kafka.download.avro.model.Model>) defaultValue(fields()[5]);
        record.price = fieldSetFlags()[6] ? this.price : (java.math.BigDecimal) defaultValue(fields()[6]);
        record.createdAt = fieldSetFlags()[7] ? this.createdAt : (java.time.Instant) defaultValue(fields()[7]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<CategoryApprovalRequestAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<CategoryApprovalRequestAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<CategoryApprovalRequestAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<CategoryApprovalRequestAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}










