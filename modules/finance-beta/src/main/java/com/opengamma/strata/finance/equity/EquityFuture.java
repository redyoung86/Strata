/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.finance.equity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.ImmutableValidator;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.basics.currency.Currency;
import com.opengamma.strata.basics.currency.CurrencyAmount;
import com.opengamma.strata.collect.ArgChecker;
import com.opengamma.strata.finance.Product;

/**
 * A futures contract, based on a single equity.
 * <p>
 * An Equity future is a financial instrument that is based on the future value of an equity.
 */
@BeanDefinition
public final class EquityFuture
    implements Product, ImmutableBean, Serializable {
  // TODO: better documentation
  // TODO: meaning of strike price and unit amount? best fields?
  // TODO: where is the size of each lot? typically 100 shares

  /**
   * The expiration date of the contract.
   * <p>
   * This is the last trading date of the contract.
   */
  @PropertyDefinition(validate = "notNull")
  private final LocalDate expirationDate;
  /**
   * The settlement date of the contract.
   * <p>
   * This is the date that the asset transfer takes place.
   */
  @PropertyDefinition(validate = "notNull")
  private final LocalDate settlementDate;
  /**
   * The strike price.
   * <p>
   * The future price of the equity agreed at the start of the contract.
   * The equity will be exchanged at this price on the settlement date.
   */
  @PropertyDefinition(validate = "notNull")
  private final double strikePrice;
  /**
   * The unit amount.
   * <p>
   * The value that one contract will move by when the equity price moves by one point.
   */
  @PropertyDefinition(validate = "notNull")
  private final CurrencyAmount unitAmount;

  //-------------------------------------------------------------------------
  @ImmutableValidator
  private void validate() {
    ArgChecker.inOrderOrEqual(expirationDate, settlementDate, "expirationDate", "settlementDate");
  }

  //-------------------------------------------------------------------------
  /**
   * Gets the currency of the future.
   * 
   * @return the currency of the future
   */
  public Currency getCurrency() {
    return unitAmount.getCurrency();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code EquityFuture}.
   * @return the meta-bean, not null
   */
  public static EquityFuture.Meta meta() {
    return EquityFuture.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(EquityFuture.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static EquityFuture.Builder builder() {
    return new EquityFuture.Builder();
  }

  private EquityFuture(
      LocalDate expirationDate,
      LocalDate settlementDate,
      double strikePrice,
      CurrencyAmount unitAmount) {
    JodaBeanUtils.notNull(expirationDate, "expirationDate");
    JodaBeanUtils.notNull(settlementDate, "settlementDate");
    JodaBeanUtils.notNull(strikePrice, "strikePrice");
    JodaBeanUtils.notNull(unitAmount, "unitAmount");
    this.expirationDate = expirationDate;
    this.settlementDate = settlementDate;
    this.strikePrice = strikePrice;
    this.unitAmount = unitAmount;
    validate();
  }

  @Override
  public EquityFuture.Meta metaBean() {
    return EquityFuture.Meta.INSTANCE;
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
   * Gets the expiration date of the contract.
   * <p>
   * This is the last trading date of the contract.
   * @return the value of the property, not null
   */
  public LocalDate getExpirationDate() {
    return expirationDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the settlement date of the contract.
   * <p>
   * This is the date that the asset transfer takes place.
   * @return the value of the property, not null
   */
  public LocalDate getSettlementDate() {
    return settlementDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the strike price.
   * <p>
   * The future price of the equity agreed at the start of the contract.
   * The equity will be exchanged at this price on the settlement date.
   * @return the value of the property, not null
   */
  public double getStrikePrice() {
    return strikePrice;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the unit amount.
   * <p>
   * The value that one contract will move by when the equity price moves by one point.
   * @return the value of the property, not null
   */
  public CurrencyAmount getUnitAmount() {
    return unitAmount;
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
      EquityFuture other = (EquityFuture) obj;
      return JodaBeanUtils.equal(getExpirationDate(), other.getExpirationDate()) &&
          JodaBeanUtils.equal(getSettlementDate(), other.getSettlementDate()) &&
          JodaBeanUtils.equal(getStrikePrice(), other.getStrikePrice()) &&
          JodaBeanUtils.equal(getUnitAmount(), other.getUnitAmount());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(getExpirationDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getSettlementDate());
    hash = hash * 31 + JodaBeanUtils.hashCode(getStrikePrice());
    hash = hash * 31 + JodaBeanUtils.hashCode(getUnitAmount());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(160);
    buf.append("EquityFuture{");
    buf.append("expirationDate").append('=').append(getExpirationDate()).append(',').append(' ');
    buf.append("settlementDate").append('=').append(getSettlementDate()).append(',').append(' ');
    buf.append("strikePrice").append('=').append(getStrikePrice()).append(',').append(' ');
    buf.append("unitAmount").append('=').append(JodaBeanUtils.toString(getUnitAmount()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code EquityFuture}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code expirationDate} property.
     */
    private final MetaProperty<LocalDate> expirationDate = DirectMetaProperty.ofImmutable(
        this, "expirationDate", EquityFuture.class, LocalDate.class);
    /**
     * The meta-property for the {@code settlementDate} property.
     */
    private final MetaProperty<LocalDate> settlementDate = DirectMetaProperty.ofImmutable(
        this, "settlementDate", EquityFuture.class, LocalDate.class);
    /**
     * The meta-property for the {@code strikePrice} property.
     */
    private final MetaProperty<Double> strikePrice = DirectMetaProperty.ofImmutable(
        this, "strikePrice", EquityFuture.class, Double.TYPE);
    /**
     * The meta-property for the {@code unitAmount} property.
     */
    private final MetaProperty<CurrencyAmount> unitAmount = DirectMetaProperty.ofImmutable(
        this, "unitAmount", EquityFuture.class, CurrencyAmount.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "expirationDate",
        "settlementDate",
        "strikePrice",
        "unitAmount");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -668811523:  // expirationDate
          return expirationDate;
        case -295948169:  // settlementDate
          return settlementDate;
        case 50946231:  // strikePrice
          return strikePrice;
        case 1673913084:  // unitAmount
          return unitAmount;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public EquityFuture.Builder builder() {
      return new EquityFuture.Builder();
    }

    @Override
    public Class<? extends EquityFuture> beanType() {
      return EquityFuture.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code expirationDate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> expirationDate() {
      return expirationDate;
    }

    /**
     * The meta-property for the {@code settlementDate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> settlementDate() {
      return settlementDate;
    }

    /**
     * The meta-property for the {@code strikePrice} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> strikePrice() {
      return strikePrice;
    }

    /**
     * The meta-property for the {@code unitAmount} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CurrencyAmount> unitAmount() {
      return unitAmount;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -668811523:  // expirationDate
          return ((EquityFuture) bean).getExpirationDate();
        case -295948169:  // settlementDate
          return ((EquityFuture) bean).getSettlementDate();
        case 50946231:  // strikePrice
          return ((EquityFuture) bean).getStrikePrice();
        case 1673913084:  // unitAmount
          return ((EquityFuture) bean).getUnitAmount();
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
   * The bean-builder for {@code EquityFuture}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<EquityFuture> {

    private LocalDate expirationDate;
    private LocalDate settlementDate;
    private double strikePrice;
    private CurrencyAmount unitAmount;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(EquityFuture beanToCopy) {
      this.expirationDate = beanToCopy.getExpirationDate();
      this.settlementDate = beanToCopy.getSettlementDate();
      this.strikePrice = beanToCopy.getStrikePrice();
      this.unitAmount = beanToCopy.getUnitAmount();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -668811523:  // expirationDate
          return expirationDate;
        case -295948169:  // settlementDate
          return settlementDate;
        case 50946231:  // strikePrice
          return strikePrice;
        case 1673913084:  // unitAmount
          return unitAmount;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -668811523:  // expirationDate
          this.expirationDate = (LocalDate) newValue;
          break;
        case -295948169:  // settlementDate
          this.settlementDate = (LocalDate) newValue;
          break;
        case 50946231:  // strikePrice
          this.strikePrice = (Double) newValue;
          break;
        case 1673913084:  // unitAmount
          this.unitAmount = (CurrencyAmount) newValue;
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
    public EquityFuture build() {
      return new EquityFuture(
          expirationDate,
          settlementDate,
          strikePrice,
          unitAmount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the expiration date of the contract.
     * <p>
     * This is the last trading date of the contract.
     * @param expirationDate  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder expirationDate(LocalDate expirationDate) {
      JodaBeanUtils.notNull(expirationDate, "expirationDate");
      this.expirationDate = expirationDate;
      return this;
    }

    /**
     * Sets the settlement date of the contract.
     * <p>
     * This is the date that the asset transfer takes place.
     * @param settlementDate  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder settlementDate(LocalDate settlementDate) {
      JodaBeanUtils.notNull(settlementDate, "settlementDate");
      this.settlementDate = settlementDate;
      return this;
    }

    /**
     * Sets the strike price.
     * <p>
     * The future price of the equity agreed at the start of the contract.
     * The equity will be exchanged at this price on the settlement date.
     * @param strikePrice  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder strikePrice(double strikePrice) {
      JodaBeanUtils.notNull(strikePrice, "strikePrice");
      this.strikePrice = strikePrice;
      return this;
    }

    /**
     * Sets the unit amount.
     * <p>
     * The value that one contract will move by when the equity price moves by one point.
     * @param unitAmount  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder unitAmount(CurrencyAmount unitAmount) {
      JodaBeanUtils.notNull(unitAmount, "unitAmount");
      this.unitAmount = unitAmount;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(160);
      buf.append("EquityFuture.Builder{");
      buf.append("expirationDate").append('=').append(JodaBeanUtils.toString(expirationDate)).append(',').append(' ');
      buf.append("settlementDate").append('=').append(JodaBeanUtils.toString(settlementDate)).append(',').append(' ');
      buf.append("strikePrice").append('=').append(JodaBeanUtils.toString(strikePrice)).append(',').append(' ');
      buf.append("unitAmount").append('=').append(JodaBeanUtils.toString(unitAmount));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
