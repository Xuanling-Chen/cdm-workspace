package cdm.product.common.settlement;

import cdm.observable.asset.Money;
import cdm.product.common.settlement.meta.PrincipalExchangeMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.MetaFields;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A data for:  defining a principal exchange amount and adjusted exchange date. This data forms:  part of the cashflow representation of a swap stream.
 * @version ${project.version}
 */
@RosettaClass

public interface PrincipalExchange extends RosettaModelObject, GlobalKey {
	PrincipalExchange build();
	PrincipalExchange.PrincipalExchangeBuilder toBuilder();
	
	/**
	 * The adjusted principal exchange date. This date should already be adjusted for any applicable business day convention.
	 */
	Date getAdjustedPrincipalExchangeDate();
	/**
	 * The value representing the discount factor used to calculate the present value of the principal exchange amount.
	 */
	BigDecimal getDiscountFactor();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The amount representing the present value of the principal exchange.
	 */
	Money getPresentValuePrincipalExchangeAmount();
	/**
	 * The principal exchange amount. This amount should be positive if the stream payer is paying the exchange amount and signed negative if they are receiving it.
	 */
	BigDecimal getPrincipalExchangeAmount();
	/**
	 * The non adjusted principal exchange date.
	 */
	Date getUnadjustedPrincipalExchangeDate();
	final static PrincipalExchangeMeta metaData = new PrincipalExchangeMeta();
	
	@Override
	default RosettaMetaData<? extends PrincipalExchange> metaData() {
		return metaData;
	} 
			
	static PrincipalExchange.PrincipalExchangeBuilder builder() {
		return new PrincipalExchange.PrincipalExchangeBuilderImpl();
	}
	
	default Class<? extends PrincipalExchange> getType() {
		return PrincipalExchange.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedPrincipalExchangeDate"), Date.class, getAdjustedPrincipalExchangeDate(), this);
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processor.processBasic(path.newSubPath("principalExchangeAmount"), BigDecimal.class, getPrincipalExchangeAmount(), this);
		processor.processBasic(path.newSubPath("unadjustedPrincipalExchangeDate"), Date.class, getUnadjustedPrincipalExchangeDate(), this);
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("presentValuePrincipalExchangeAmount"), processor, Money.class, getPresentValuePrincipalExchangeAmount());
	}
	
	
	interface PrincipalExchangeBuilder extends PrincipalExchange, RosettaModelObjectBuilder {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Money.MoneyBuilder getOrCreatePresentValuePrincipalExchangeAmount();
		Money.MoneyBuilder getPresentValuePrincipalExchangeAmount();
		PrincipalExchange.PrincipalExchangeBuilder setAdjustedPrincipalExchangeDate(Date adjustedPrincipalExchangeDate);
		PrincipalExchange.PrincipalExchangeBuilder setDiscountFactor(BigDecimal discountFactor);
		PrincipalExchange.PrincipalExchangeBuilder setMeta(MetaFields meta);
		PrincipalExchange.PrincipalExchangeBuilder setPresentValuePrincipalExchangeAmount(Money presentValuePrincipalExchangeAmount);
		PrincipalExchange.PrincipalExchangeBuilder setPrincipalExchangeAmount(BigDecimal principalExchangeAmount);
		PrincipalExchange.PrincipalExchangeBuilder setUnadjustedPrincipalExchangeDate(Date unadjustedPrincipalExchangeDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("adjustedPrincipalExchangeDate"), Date.class, getAdjustedPrincipalExchangeDate(), this);
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processor.processBasic(path.newSubPath("principalExchangeAmount"), BigDecimal.class, getPrincipalExchangeAmount(), this);
			processor.processBasic(path.newSubPath("unadjustedPrincipalExchangeDate"), Date.class, getUnadjustedPrincipalExchangeDate(), this);
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("presentValuePrincipalExchangeAmount"), processor, Money.MoneyBuilder.class, getPresentValuePrincipalExchangeAmount());
		}
		
	}
	
	//PrincipalExchange.PrincipalExchangeImpl
	class PrincipalExchangeImpl implements PrincipalExchange {
		private final Date adjustedPrincipalExchangeDate;
		private final BigDecimal discountFactor;
		private final MetaFields meta;
		private final Money presentValuePrincipalExchangeAmount;
		private final BigDecimal principalExchangeAmount;
		private final Date unadjustedPrincipalExchangeDate;
		
		protected PrincipalExchangeImpl(PrincipalExchange.PrincipalExchangeBuilder builder) {
			this.adjustedPrincipalExchangeDate = builder.getAdjustedPrincipalExchangeDate();
			this.discountFactor = builder.getDiscountFactor();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.presentValuePrincipalExchangeAmount = ofNullable(builder.getPresentValuePrincipalExchangeAmount()).map(f->f.build()).orElse(null);
			this.principalExchangeAmount = builder.getPrincipalExchangeAmount();
			this.unadjustedPrincipalExchangeDate = builder.getUnadjustedPrincipalExchangeDate();
		}
		
		@Override
		public Date getAdjustedPrincipalExchangeDate() {
			return adjustedPrincipalExchangeDate;
		}
		
		@Override
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Money getPresentValuePrincipalExchangeAmount() {
			return presentValuePrincipalExchangeAmount;
		}
		
		@Override
		public BigDecimal getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		public Date getUnadjustedPrincipalExchangeDate() {
			return unadjustedPrincipalExchangeDate;
		}
		
		@Override
		public PrincipalExchange build() {
			return this;
		}
		
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder toBuilder() {
			PrincipalExchange.PrincipalExchangeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PrincipalExchange.PrincipalExchangeBuilder builder) {
			ofNullable(getAdjustedPrincipalExchangeDate()).ifPresent(builder::setAdjustedPrincipalExchangeDate);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPresentValuePrincipalExchangeAmount()).ifPresent(builder::setPresentValuePrincipalExchangeAmount);
			ofNullable(getPrincipalExchangeAmount()).ifPresent(builder::setPrincipalExchangeAmount);
			ofNullable(getUnadjustedPrincipalExchangeDate()).ifPresent(builder::setUnadjustedPrincipalExchangeDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchange _that = getType().cast(o);
		
			if (!Objects.equals(adjustedPrincipalExchangeDate, _that.getAdjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(presentValuePrincipalExchangeAmount, _that.getPresentValuePrincipalExchangeAmount())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(unadjustedPrincipalExchangeDate, _that.getUnadjustedPrincipalExchangeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedPrincipalExchangeDate != null ? adjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (presentValuePrincipalExchangeAmount != null ? presentValuePrincipalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (unadjustedPrincipalExchangeDate != null ? unadjustedPrincipalExchangeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchange {" +
				"adjustedPrincipalExchangeDate=" + this.adjustedPrincipalExchangeDate + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"meta=" + this.meta + ", " +
				"presentValuePrincipalExchangeAmount=" + this.presentValuePrincipalExchangeAmount + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"unadjustedPrincipalExchangeDate=" + this.unadjustedPrincipalExchangeDate +
			'}';
		}
	}
	
	//PrincipalExchange.PrincipalExchangeBuilderImpl
	class PrincipalExchangeBuilderImpl implements PrincipalExchange.PrincipalExchangeBuilder, GlobalKeyBuilder {
	
		protected Date adjustedPrincipalExchangeDate;
		protected BigDecimal discountFactor;
		protected MetaFields.MetaFieldsBuilder meta;
		protected Money.MoneyBuilder presentValuePrincipalExchangeAmount;
		protected BigDecimal principalExchangeAmount;
		protected Date unadjustedPrincipalExchangeDate;
	
		public PrincipalExchangeBuilderImpl() {
		}
	
		@Override
		public Date getAdjustedPrincipalExchangeDate() {
			return adjustedPrincipalExchangeDate;
		}
		
		@Override
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public Money.MoneyBuilder getPresentValuePrincipalExchangeAmount() {
			return presentValuePrincipalExchangeAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValuePrincipalExchangeAmount() {
			Money.MoneyBuilder result;
			if (presentValuePrincipalExchangeAmount!=null) {
				result = presentValuePrincipalExchangeAmount;
			}
			else {
				result = presentValuePrincipalExchangeAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getPrincipalExchangeAmount() {
			return principalExchangeAmount;
		}
		
		@Override
		public Date getUnadjustedPrincipalExchangeDate() {
			return unadjustedPrincipalExchangeDate;
		}
		
	
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setAdjustedPrincipalExchangeDate(Date adjustedPrincipalExchangeDate) {
			this.adjustedPrincipalExchangeDate = adjustedPrincipalExchangeDate==null?null:adjustedPrincipalExchangeDate;
			return this;
		}
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setPresentValuePrincipalExchangeAmount(Money presentValuePrincipalExchangeAmount) {
			this.presentValuePrincipalExchangeAmount = presentValuePrincipalExchangeAmount==null?null:presentValuePrincipalExchangeAmount.toBuilder();
			return this;
		}
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setPrincipalExchangeAmount(BigDecimal principalExchangeAmount) {
			this.principalExchangeAmount = principalExchangeAmount==null?null:principalExchangeAmount;
			return this;
		}
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder setUnadjustedPrincipalExchangeDate(Date unadjustedPrincipalExchangeDate) {
			this.unadjustedPrincipalExchangeDate = unadjustedPrincipalExchangeDate==null?null:unadjustedPrincipalExchangeDate;
			return this;
		}
		
		@Override
		public PrincipalExchange build() {
			return new PrincipalExchange.PrincipalExchangeImpl(this);
		}
		
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (presentValuePrincipalExchangeAmount!=null && !presentValuePrincipalExchangeAmount.prune().hasData()) presentValuePrincipalExchangeAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedPrincipalExchangeDate()!=null) return true;
			if (getDiscountFactor()!=null) return true;
			if (getPresentValuePrincipalExchangeAmount()!=null && getPresentValuePrincipalExchangeAmount().hasData()) return true;
			if (getPrincipalExchangeAmount()!=null) return true;
			if (getUnadjustedPrincipalExchangeDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PrincipalExchange.PrincipalExchangeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PrincipalExchange.PrincipalExchangeBuilder o = (PrincipalExchange.PrincipalExchangeBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPresentValuePrincipalExchangeAmount(), o.getPresentValuePrincipalExchangeAmount(), this::setPresentValuePrincipalExchangeAmount);
			
			merger.mergeBasic(getAdjustedPrincipalExchangeDate(), o.getAdjustedPrincipalExchangeDate(), this::setAdjustedPrincipalExchangeDate);
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			merger.mergeBasic(getPrincipalExchangeAmount(), o.getPrincipalExchangeAmount(), this::setPrincipalExchangeAmount);
			merger.mergeBasic(getUnadjustedPrincipalExchangeDate(), o.getUnadjustedPrincipalExchangeDate(), this::setUnadjustedPrincipalExchangeDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PrincipalExchange _that = getType().cast(o);
		
			if (!Objects.equals(adjustedPrincipalExchangeDate, _that.getAdjustedPrincipalExchangeDate())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(presentValuePrincipalExchangeAmount, _that.getPresentValuePrincipalExchangeAmount())) return false;
			if (!Objects.equals(principalExchangeAmount, _that.getPrincipalExchangeAmount())) return false;
			if (!Objects.equals(unadjustedPrincipalExchangeDate, _that.getUnadjustedPrincipalExchangeDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedPrincipalExchangeDate != null ? adjustedPrincipalExchangeDate.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (presentValuePrincipalExchangeAmount != null ? presentValuePrincipalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (principalExchangeAmount != null ? principalExchangeAmount.hashCode() : 0);
			_result = 31 * _result + (unadjustedPrincipalExchangeDate != null ? unadjustedPrincipalExchangeDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PrincipalExchangeBuilder {" +
				"adjustedPrincipalExchangeDate=" + this.adjustedPrincipalExchangeDate + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"meta=" + this.meta + ", " +
				"presentValuePrincipalExchangeAmount=" + this.presentValuePrincipalExchangeAmount + ", " +
				"principalExchangeAmount=" + this.principalExchangeAmount + ", " +
				"unadjustedPrincipalExchangeDate=" + this.unadjustedPrincipalExchangeDate +
			'}';
		}
	}
}
