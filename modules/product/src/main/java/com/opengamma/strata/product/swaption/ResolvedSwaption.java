/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.swaption;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZonedDateTime;
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

import com.google.common.collect.Iterables;
import com.opengamma.strata.basics.LongShort;
import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.basics.index.IborIndex;
import com.opengamma.strata.basics.market.ReferenceData;
import com.opengamma.strata.product.ResolvedProduct;
import com.opengamma.strata.product.swap.ResolvedSwap;

/**
 * A swaption, resolved for pricing.
 * <p>
 * This is the resolved form of {@link Swaption} and is an input to the pricers.
 * Applications will typically create a {@code ResolvedSwaption} from a {@code Swaption}
 * using {@link Swaption#resolve(ReferenceData)}.
 * <p>
 * A {@code ResolvedSwaption} is bound to data that changes over time, such as holiday calendars.
 * If the data changes, such as the addition of a new holiday, the resolved form will not be updated.
 * Care must be taken when placing the resolved form in a cache or persistence layer.
 */
@BeanDefinition
public final class ResolvedSwaption
    implements ResolvedProduct, ImmutableBean, Serializable {

  /**
   * Whether the option is long or short.
   * <p>
   * Long indicates that the owner wants the option to be in the money at expiry.
   * Short indicates that the owner wants the option to be out of the money at expiry.
   */
  @PropertyDefinition(validate = "notNull")
  private final LongShort longShort;
  /**
   * Settlement method.  
   * <p>
   * The settlement of the option is specified by {@link SwaptionSettlement}.
   */
  @PropertyDefinition(validate = "notNull")
  private final SwaptionSettlement swaptionSettlement;
  /**
   * The expiry date-time of the option.
   * <p>
   * The option is European, and can only be exercised on the expiry date.
   */
  @PropertyDefinition(validate = "notNull")
  private final ZonedDateTime expiry;
  /**
   * The underlying swap.
   * <p>
   * At expiry, if the option is exercised, this swap will be entered into. The swap description is the swap 
   * as viewed by the party long the option. 
   */
  @PropertyDefinition(validate = "notNull")
  private final ResolvedSwap underlying;

  //-------------------------------------------------------------------------
  /**
   * Gets the expiry date of the option.
   * 
   * @return the expiry date
   */
  public LocalDate getExpiryDate() {
    return expiry.toLocalDate();
  }

  /**
   * Gets the currency of the swaption.
   * <p>
   * This is the currency of the underlying swap, which is not allowed to be cross-currency.
   * 
   * @return the currency
   */
  public Currency getCurrency() {
    return Iterables.getOnlyElement(underlying.allCurrencies());
  }

  /**
   * Gets the index of the underlying swap.
   * 
   * @return the Ibor index of the underlying swap
   */
  public IborIndex getIndex() {
    return (IborIndex) underlying.allIndices().iterator().next();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code ResolvedSwaption}.
   * @return the meta-bean, not null
   */
  public static ResolvedSwaption.Meta meta() {
    return ResolvedSwaption.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(ResolvedSwaption.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static ResolvedSwaption.Builder builder() {
    return new ResolvedSwaption.Builder();
  }

  private ResolvedSwaption(
      LongShort longShort,
      SwaptionSettlement swaptionSettlement,
      ZonedDateTime expiry,
      ResolvedSwap underlying) {
    JodaBeanUtils.notNull(longShort, "longShort");
    JodaBeanUtils.notNull(swaptionSettlement, "swaptionSettlement");
    JodaBeanUtils.notNull(expiry, "expiry");
    JodaBeanUtils.notNull(underlying, "underlying");
    this.longShort = longShort;
    this.swaptionSettlement = swaptionSettlement;
    this.expiry = expiry;
    this.underlying = underlying;
  }

  @Override
  public ResolvedSwaption.Meta metaBean() {
    return ResolvedSwaption.Meta.INSTANCE;
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
   * Gets whether the option is long or short.
   * <p>
   * Long indicates that the owner wants the option to be in the money at expiry.
   * Short indicates that the owner wants the option to be out of the money at expiry.
   * @return the value of the property, not null
   */
  public LongShort getLongShort() {
    return longShort;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets settlement method.
   * <p>
   * The settlement of the option is specified by {@link SwaptionSettlement}.
   * @return the value of the property, not null
   */
  public SwaptionSettlement getSwaptionSettlement() {
    return swaptionSettlement;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the expiry date-time of the option.
   * <p>
   * The option is European, and can only be exercised on the expiry date.
   * @return the value of the property, not null
   */
  public ZonedDateTime getExpiry() {
    return expiry;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the underlying swap.
   * <p>
   * At expiry, if the option is exercised, this swap will be entered into. The swap description is the swap
   * as viewed by the party long the option.
   * @return the value of the property, not null
   */
  public ResolvedSwap getUnderlying() {
    return underlying;
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
      ResolvedSwaption other = (ResolvedSwaption) obj;
      return JodaBeanUtils.equal(longShort, other.longShort) &&
          JodaBeanUtils.equal(swaptionSettlement, other.swaptionSettlement) &&
          JodaBeanUtils.equal(expiry, other.expiry) &&
          JodaBeanUtils.equal(underlying, other.underlying);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(longShort);
    hash = hash * 31 + JodaBeanUtils.hashCode(swaptionSettlement);
    hash = hash * 31 + JodaBeanUtils.hashCode(expiry);
    hash = hash * 31 + JodaBeanUtils.hashCode(underlying);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("ResolvedSwaption{");
    buf.append("longShort").append('=').append(longShort).append(',').append(' ');
    buf.append("swaptionSettlement").append('=').append(swaptionSettlement).append(',').append(' ');
    buf.append("expiry").append('=').append(expiry).append(',').append(' ');
    buf.append("underlying").append('=').append(JodaBeanUtils.toString(underlying));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code ResolvedSwaption}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code longShort} property.
     */
    private final MetaProperty<LongShort> longShort = DirectMetaProperty.ofImmutable(
        this, "longShort", ResolvedSwaption.class, LongShort.class);
    /**
     * The meta-property for the {@code swaptionSettlement} property.
     */
    private final MetaProperty<SwaptionSettlement> swaptionSettlement = DirectMetaProperty.ofImmutable(
        this, "swaptionSettlement", ResolvedSwaption.class, SwaptionSettlement.class);
    /**
     * The meta-property for the {@code expiry} property.
     */
    private final MetaProperty<ZonedDateTime> expiry = DirectMetaProperty.ofImmutable(
        this, "expiry", ResolvedSwaption.class, ZonedDateTime.class);
    /**
     * The meta-property for the {@code underlying} property.
     */
    private final MetaProperty<ResolvedSwap> underlying = DirectMetaProperty.ofImmutable(
        this, "underlying", ResolvedSwaption.class, ResolvedSwap.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "longShort",
        "swaptionSettlement",
        "expiry",
        "underlying");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 116685664:  // longShort
          return longShort;
        case -1937554512:  // swaptionSettlement
          return swaptionSettlement;
        case -1289159373:  // expiry
          return expiry;
        case -1770633379:  // underlying
          return underlying;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public ResolvedSwaption.Builder builder() {
      return new ResolvedSwaption.Builder();
    }

    @Override
    public Class<? extends ResolvedSwaption> beanType() {
      return ResolvedSwaption.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code longShort} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LongShort> longShort() {
      return longShort;
    }

    /**
     * The meta-property for the {@code swaptionSettlement} property.
     * @return the meta-property, not null
     */
    public MetaProperty<SwaptionSettlement> swaptionSettlement() {
      return swaptionSettlement;
    }

    /**
     * The meta-property for the {@code expiry} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ZonedDateTime> expiry() {
      return expiry;
    }

    /**
     * The meta-property for the {@code underlying} property.
     * @return the meta-property, not null
     */
    public MetaProperty<ResolvedSwap> underlying() {
      return underlying;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 116685664:  // longShort
          return ((ResolvedSwaption) bean).getLongShort();
        case -1937554512:  // swaptionSettlement
          return ((ResolvedSwaption) bean).getSwaptionSettlement();
        case -1289159373:  // expiry
          return ((ResolvedSwaption) bean).getExpiry();
        case -1770633379:  // underlying
          return ((ResolvedSwaption) bean).getUnderlying();
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
   * The bean-builder for {@code ResolvedSwaption}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<ResolvedSwaption> {

    private LongShort longShort;
    private SwaptionSettlement swaptionSettlement;
    private ZonedDateTime expiry;
    private ResolvedSwap underlying;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(ResolvedSwaption beanToCopy) {
      this.longShort = beanToCopy.getLongShort();
      this.swaptionSettlement = beanToCopy.getSwaptionSettlement();
      this.expiry = beanToCopy.getExpiry();
      this.underlying = beanToCopy.getUnderlying();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 116685664:  // longShort
          return longShort;
        case -1937554512:  // swaptionSettlement
          return swaptionSettlement;
        case -1289159373:  // expiry
          return expiry;
        case -1770633379:  // underlying
          return underlying;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 116685664:  // longShort
          this.longShort = (LongShort) newValue;
          break;
        case -1937554512:  // swaptionSettlement
          this.swaptionSettlement = (SwaptionSettlement) newValue;
          break;
        case -1289159373:  // expiry
          this.expiry = (ZonedDateTime) newValue;
          break;
        case -1770633379:  // underlying
          this.underlying = (ResolvedSwap) newValue;
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
    public ResolvedSwaption build() {
      return new ResolvedSwaption(
          longShort,
          swaptionSettlement,
          expiry,
          underlying);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets whether the option is long or short.
     * <p>
     * Long indicates that the owner wants the option to be in the money at expiry.
     * Short indicates that the owner wants the option to be out of the money at expiry.
     * @param longShort  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder longShort(LongShort longShort) {
      JodaBeanUtils.notNull(longShort, "longShort");
      this.longShort = longShort;
      return this;
    }

    /**
     * Sets settlement method.
     * <p>
     * The settlement of the option is specified by {@link SwaptionSettlement}.
     * @param swaptionSettlement  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder swaptionSettlement(SwaptionSettlement swaptionSettlement) {
      JodaBeanUtils.notNull(swaptionSettlement, "swaptionSettlement");
      this.swaptionSettlement = swaptionSettlement;
      return this;
    }

    /**
     * Sets the expiry date-time of the option.
     * <p>
     * The option is European, and can only be exercised on the expiry date.
     * @param expiry  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder expiry(ZonedDateTime expiry) {
      JodaBeanUtils.notNull(expiry, "expiry");
      this.expiry = expiry;
      return this;
    }

    /**
     * Sets the underlying swap.
     * <p>
     * At expiry, if the option is exercised, this swap will be entered into. The swap description is the swap
     * as viewed by the party long the option.
     * @param underlying  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder underlying(ResolvedSwap underlying) {
      JodaBeanUtils.notNull(underlying, "underlying");
      this.underlying = underlying;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("ResolvedSwaption.Builder{");
      buf.append("longShort").append('=').append(JodaBeanUtils.toString(longShort)).append(',').append(' ');
      buf.append("swaptionSettlement").append('=').append(JodaBeanUtils.toString(swaptionSettlement)).append(',').append(' ');
      buf.append("expiry").append('=').append(JodaBeanUtils.toString(expiry)).append(',').append(' ');
      buf.append("underlying").append('=').append(JodaBeanUtils.toString(underlying));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
