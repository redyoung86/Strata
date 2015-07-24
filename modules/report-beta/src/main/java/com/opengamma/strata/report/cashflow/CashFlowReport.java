/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.strata.report.cashflow;

import java.io.OutputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.google.common.collect.ImmutableList;
import com.opengamma.strata.market.explain.ExplainKey;
import com.opengamma.strata.report.Report;

/**
 * Represents a cash flow report.
 * <p>
 * This consists of fields captured as part of a calculation. The rows are generally ordered
 * through time, and neighbouring rows may show related flows - for example, a payment period
 * containing multiple resets.
 */
@BeanDefinition
public class CashFlowReport implements Report, ImmutableBean {

  /** The valuation date. */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final LocalDate valuationDate;

  /** The instant at which the report was run. */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final Instant runInstant;

  /** The keys corresponding to the columns. */
  @PropertyDefinition(validate = "notNull")
  private final List<ExplainKey<?>> columnKeys;

  /** The column headers.  */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final String[] columnHeaders;

  /** The cashflow data table. */
  @PropertyDefinition(validate = "notNull")
  private final Object[][] data;

  @Override
  public int getRowCount() {
    return data.length;
  }

  @Override
  public void writeCsv(OutputStream out) {
    CashFlowReportFormatter.INSTANCE.writeCsv(this, out);
  }

  @Override
  public void writeAsciiTable(OutputStream out) {
    CashFlowReportFormatter.INSTANCE.writeAsciiTable(this, out);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code CashFlowReport}.
   * @return the meta-bean, not null
   */
  public static CashFlowReport.Meta meta() {
    return CashFlowReport.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(CashFlowReport.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static CashFlowReport.Builder builder() {
    return new CashFlowReport.Builder();
  }

  /**
   * Restricted constructor.
   * @param builder  the builder to copy from, not null
   */
  protected CashFlowReport(CashFlowReport.Builder builder) {
    JodaBeanUtils.notNull(builder.valuationDate, "valuationDate");
    JodaBeanUtils.notNull(builder.runInstant, "runInstant");
    JodaBeanUtils.notNull(builder.columnKeys, "columnKeys");
    JodaBeanUtils.notNull(builder.columnHeaders, "columnHeaders");
    JodaBeanUtils.notNull(builder.data, "data");
    this.valuationDate = builder.valuationDate;
    this.runInstant = builder.runInstant;
    this.columnKeys = ImmutableList.copyOf(builder.columnKeys);
    this.columnHeaders = builder.columnHeaders.clone();
    this.data = builder.data;
  }

  @Override
  public CashFlowReport.Meta metaBean() {
    return CashFlowReport.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the valuation date.
   * @return the value of the property, not null
   */
  @Override
  public LocalDate getValuationDate() {
    return valuationDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the instant at which the report was run.
   * @return the value of the property, not null
   */
  @Override
  public Instant getRunInstant() {
    return runInstant;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the keys corresponding to the columns.
   * @return the value of the property, not null
   */
  public List<ExplainKey<?>> getColumnKeys() {
    return columnKeys;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the column headers.
   * @return the value of the property, not null
   */
  @Override
  public String[] getColumnHeaders() {
    return (columnHeaders != null ? columnHeaders.clone() : null);
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the cashflow data table.
   * @return the value of the property, not null
   */
  public Object[][] getData() {
    return data;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      CashFlowReport other = (CashFlowReport) obj;
      return JodaBeanUtils.equal(getValuationDate(), other.getValuationDate()) &&
          JodaBeanUtils.equal(getRunInstant(), other.getRunInstant()) &&
          JodaBeanUtils.equal(getColumnKeys(), other.getColumnKeys()) &&
          JodaBeanUtils.equal(getColumnHeaders(), other.getColumnHeaders()) &&
          JodaBeanUtils.equal(getData(), other.getData());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getValuationDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getRunInstant());
    hash = hash * 31 + JodaBeanUtils.hashCode(getColumnKeys());
    hash = hash * 31 + JodaBeanUtils.hashCode(getColumnHeaders());
    hash = hash * 31 + JodaBeanUtils.hashCode(getData());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(192);
    buf.append("CashFlowReport{");
    int len = buf.length();
    toString(buf);
    if (buf.length() > len) {
      buf.setLength(buf.length() - 2);
    }
    buf.append('}');
    return buf.toString();
  }

  protected void toString(StringBuilder buf) {
    buf.append("valuationDate").append('=').append(JodaBeanUtils.toString(getValuationDate())).append(',').append(' ');
    buf.append("runInstant").append('=').append(JodaBeanUtils.toString(getRunInstant())).append(',').append(' ');
    buf.append("columnKeys").append('=').append(JodaBeanUtils.toString(getColumnKeys())).append(',').append(' ');
    buf.append("columnHeaders").append('=').append(JodaBeanUtils.toString(getColumnHeaders())).append(',').append(' ');
    buf.append("data").append('=').append(JodaBeanUtils.toString(getData())).append(',').append(' ');
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code CashFlowReport}.
   */
  public static class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code valuationDate} property.
     */
    private final MetaProperty<LocalDate> valuationDate = DirectMetaProperty.ofImmutable(
        this, "valuationDate", CashFlowReport.class, LocalDate.class);
    /**
     * The meta-property for the {@code runInstant} property.
     */
    private final MetaProperty<Instant> runInstant = DirectMetaProperty.ofImmutable(
        this, "runInstant", CashFlowReport.class, Instant.class);
    /**
     * The meta-property for the {@code columnKeys} property.
     */
    @SuppressWarnings({"unchecked", "rawtypes" })
    private final MetaProperty<List<ExplainKey<?>>> columnKeys = DirectMetaProperty.ofImmutable(
        this, "columnKeys", CashFlowReport.class, (Class) List.class);
    /**
     * The meta-property for the {@code columnHeaders} property.
     */
    private final MetaProperty<String[]> columnHeaders = DirectMetaProperty.ofImmutable(
        this, "columnHeaders", CashFlowReport.class, String[].class);
    /**
     * The meta-property for the {@code data} property.
     */
    private final MetaProperty<Object[][]> data = DirectMetaProperty.ofImmutable(
        this, "data", CashFlowReport.class, Object[][].class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "valuationDate",
        "runInstant",
        "columnKeys",
        "columnHeaders",
        "data");

    /**
     * Restricted constructor.
     */
    protected Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 113107279:  // valuationDate
          return valuationDate;
        case 111354070:  // runInstant
          return runInstant;
        case -2105746838:  // columnKeys
          return columnKeys;
        case 1598220112:  // columnHeaders
          return columnHeaders;
        case 3076010:  // data
          return data;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public CashFlowReport.Builder builder() {
      return new CashFlowReport.Builder();
    }

    @Override
    public Class<? extends CashFlowReport> beanType() {
      return CashFlowReport.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code valuationDate} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<LocalDate> valuationDate() {
      return valuationDate;
    }

    /**
     * The meta-property for the {@code runInstant} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Instant> runInstant() {
      return runInstant;
    }

    /**
     * The meta-property for the {@code columnKeys} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<List<ExplainKey<?>>> columnKeys() {
      return columnKeys;
    }

    /**
     * The meta-property for the {@code columnHeaders} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<String[]> columnHeaders() {
      return columnHeaders;
    }

    /**
     * The meta-property for the {@code data} property.
     * @return the meta-property, not null
     */
    public final MetaProperty<Object[][]> data() {
      return data;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 113107279:  // valuationDate
          return ((CashFlowReport) bean).getValuationDate();
        case 111354070:  // runInstant
          return ((CashFlowReport) bean).getRunInstant();
        case -2105746838:  // columnKeys
          return ((CashFlowReport) bean).getColumnKeys();
        case 1598220112:  // columnHeaders
          return ((CashFlowReport) bean).getColumnHeaders();
        case 3076010:  // data
          return ((CashFlowReport) bean).getData();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code CashFlowReport}.
   */
  public static class Builder extends DirectFieldsBeanBuilder<CashFlowReport> {

    private LocalDate valuationDate;
    private Instant runInstant;
    private List<ExplainKey<?>> columnKeys = ImmutableList.of();
    private String[] columnHeaders;
    private Object[][] data;

    /**
     * Restricted constructor.
     */
    protected Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    protected Builder(CashFlowReport beanToCopy) {
      this.valuationDate = beanToCopy.getValuationDate();
      this.runInstant = beanToCopy.getRunInstant();
      this.columnKeys = ImmutableList.copyOf(beanToCopy.getColumnKeys());
      this.columnHeaders = beanToCopy.getColumnHeaders().clone();
      this.data = beanToCopy.getData();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 113107279:  // valuationDate
          return valuationDate;
        case 111354070:  // runInstant
          return runInstant;
        case -2105746838:  // columnKeys
          return columnKeys;
        case 1598220112:  // columnHeaders
          return columnHeaders;
        case 3076010:  // data
          return data;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 113107279:  // valuationDate
          this.valuationDate = (LocalDate) newValue;
          break;
        case 111354070:  // runInstant
          this.runInstant = (Instant) newValue;
          break;
        case -2105746838:  // columnKeys
          this.columnKeys = (List<ExplainKey<?>>) newValue;
          break;
        case 1598220112:  // columnHeaders
          this.columnHeaders = (String[]) newValue;
          break;
        case 3076010:  // data
          this.data = (Object[][]) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public CashFlowReport build() {
      return new CashFlowReport(this);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the valuation date.
     * @param valuationDate  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder valuationDate(LocalDate valuationDate) {
      JodaBeanUtils.notNull(valuationDate, "valuationDate");
      this.valuationDate = valuationDate;
      return this;
    }

    /**
     * Sets the instant at which the report was run.
     * @param runInstant  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder runInstant(Instant runInstant) {
      JodaBeanUtils.notNull(runInstant, "runInstant");
      this.runInstant = runInstant;
      return this;
    }

    /**
     * Sets the keys corresponding to the columns.
     * @param columnKeys  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder columnKeys(List<ExplainKey<?>> columnKeys) {
      JodaBeanUtils.notNull(columnKeys, "columnKeys");
      this.columnKeys = columnKeys;
      return this;
    }

    /**
     * Sets the {@code columnKeys} property in the builder
     * from an array of objects.
     * @param columnKeys  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder columnKeys(ExplainKey<?>... columnKeys) {
      return columnKeys(ImmutableList.copyOf(columnKeys));
    }

    /**
     * Sets the column headers.
     * @param columnHeaders  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder columnHeaders(String... columnHeaders) {
      JodaBeanUtils.notNull(columnHeaders, "columnHeaders");
      this.columnHeaders = columnHeaders;
      return this;
    }

    /**
     * Sets the cashflow data table.
     * @param data  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder data(Object[][] data) {
      JodaBeanUtils.notNull(data, "data");
      this.data = data;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(192);
      buf.append("CashFlowReport.Builder{");
      int len = buf.length();
      toString(buf);
      if (buf.length() > len) {
        buf.setLength(buf.length() - 2);
      }
      buf.append('}');
      return buf.toString();
    }

    protected void toString(StringBuilder buf) {
      buf.append("valuationDate").append('=').append(JodaBeanUtils.toString(valuationDate)).append(',').append(' ');
      buf.append("runInstant").append('=').append(JodaBeanUtils.toString(runInstant)).append(',').append(' ');
      buf.append("columnKeys").append('=').append(JodaBeanUtils.toString(columnKeys)).append(',').append(' ');
      buf.append("columnHeaders").append('=').append(JodaBeanUtils.toString(columnHeaders)).append(',').append(' ');
      buf.append("data").append('=').append(JodaBeanUtils.toString(data)).append(',').append(' ');
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
