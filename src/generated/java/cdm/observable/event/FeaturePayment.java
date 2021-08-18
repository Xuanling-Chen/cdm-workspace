package cdm.observable.event;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.observable.common.TimeTypeEnum;
import cdm.observable.event.meta.FeaturePaymentMeta;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Payment made following trigger occurrence.
 * @version ${project.version}
 */
@RosettaClass

public interface FeaturePayment extends RosettaModelObject, GlobalKey {
	FeaturePayment build();
	FeaturePayment.FeaturePaymentBuilder toBuilder();
	
	/**
	 * The monetary quantity in currency units.
	 */
	BigDecimal getAmount();
	/**
	 * The currency in which an amount is denominated.
	 */
	FieldWithMetaString getCurrency();
	/**
	 * The trigger level percentage.
	 */
	BigDecimal getLevelPercentage();
	/**
	 */
	MetaFields getMeta();
	/**
	 * This attribute doesn&#39;t exist as part of the FpML construct, which makes use of the PayerReceiver.model group.
	 */
	PartyReferencePayerReceiver getPayerReceiver();
	/**
	 * The feature payment date.
	 */
	AdjustableOrRelativeDate getPaymentDate();
	/**
	 * The feature payment time.
	 */
	TimeTypeEnum getTime();
	final static FeaturePaymentMeta metaData = new FeaturePaymentMeta();
	
	@Override
	default RosettaMetaData<? extends FeaturePayment> metaData() {
		return metaData;
	} 
			
	static FeaturePayment.FeaturePaymentBuilder builder() {
		return new FeaturePayment.FeaturePaymentBuilderImpl();
	}
	
	default Class<? extends FeaturePayment> getType() {
		return FeaturePayment.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
		processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
		processor.processBasic(path.newSubPath("time"), TimeTypeEnum.class, getTime(), this);
		
		processRosetta(path.newSubPath("currency"), processor, FieldWithMetaString.class, getCurrency());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.class, getPayerReceiver());
		processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.class, getPaymentDate());
	}
	
	
	interface FeaturePaymentBuilder extends FeaturePayment, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateCurrency();
		FieldWithMetaStringBuilder getCurrency();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate();
		FeaturePayment.FeaturePaymentBuilder setAmount(BigDecimal amount);
		FeaturePayment.FeaturePaymentBuilder setCurrency(FieldWithMetaString currency);
		FeaturePayment.FeaturePaymentBuilder setCurrencyValue(String currency);
		FeaturePayment.FeaturePaymentBuilder setLevelPercentage(BigDecimal levelPercentage);
		FeaturePayment.FeaturePaymentBuilder setMeta(MetaFields meta);
		FeaturePayment.FeaturePaymentBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver);
		FeaturePayment.FeaturePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate);
		FeaturePayment.FeaturePaymentBuilder setTime(TimeTypeEnum time);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("amount"), BigDecimal.class, getAmount(), this);
			processor.processBasic(path.newSubPath("levelPercentage"), BigDecimal.class, getLevelPercentage(), this);
			processor.processBasic(path.newSubPath("time"), TimeTypeEnum.class, getTime(), this);
			
			processRosetta(path.newSubPath("currency"), processor, FieldWithMetaStringBuilder.class, getCurrency());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder.class, getPayerReceiver());
			processRosetta(path.newSubPath("paymentDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getPaymentDate());
		}
		
	}
	
	//FeaturePayment.FeaturePaymentImpl
	class FeaturePaymentImpl implements FeaturePayment {
		private final BigDecimal amount;
		private final FieldWithMetaString currency;
		private final BigDecimal levelPercentage;
		private final MetaFields meta;
		private final PartyReferencePayerReceiver payerReceiver;
		private final AdjustableOrRelativeDate paymentDate;
		private final TimeTypeEnum time;
		
		protected FeaturePaymentImpl(FeaturePayment.FeaturePaymentBuilder builder) {
			this.amount = builder.getAmount();
			this.currency = ofNullable(builder.getCurrency()).map(f->f.build()).orElse(null);
			this.levelPercentage = builder.getLevelPercentage();
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
			this.paymentDate = ofNullable(builder.getPaymentDate()).map(f->f.build()).orElse(null);
			this.time = builder.getTime();
		}
		
		@Override
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public FieldWithMetaString getCurrency() {
			return currency;
		}
		
		@Override
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public PartyReferencePayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public AdjustableOrRelativeDate getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public TimeTypeEnum getTime() {
			return time;
		}
		
		@Override
		public FeaturePayment build() {
			return this;
		}
		
		@Override
		public FeaturePayment.FeaturePaymentBuilder toBuilder() {
			FeaturePayment.FeaturePaymentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FeaturePayment.FeaturePaymentBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getLevelPercentage()).ifPresent(builder::setLevelPercentage);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
			ofNullable(getPaymentDate()).ifPresent(builder::setPaymentDate);
			ofNullable(getTime()).ifPresent(builder::setTime);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeaturePayment _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeaturePayment {" +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"meta=" + this.meta + ", " +
				"payerReceiver=" + this.payerReceiver + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"time=" + this.time +
			'}';
		}
	}
	
	//FeaturePayment.FeaturePaymentBuilderImpl
	class FeaturePaymentBuilderImpl implements FeaturePayment.FeaturePaymentBuilder, GlobalKeyBuilder {
	
		protected BigDecimal amount;
		protected FieldWithMetaStringBuilder currency;
		protected BigDecimal levelPercentage;
		protected MetaFields.MetaFieldsBuilder meta;
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder payerReceiver;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder paymentDate;
		protected TimeTypeEnum time;
	
		public FeaturePaymentBuilderImpl() {
		}
	
		@Override
		public BigDecimal getAmount() {
			return amount;
		}
		
		@Override
		public FieldWithMetaStringBuilder getCurrency() {
			return currency;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateCurrency() {
			FieldWithMetaStringBuilder result;
			if (currency!=null) {
				result = currency;
			}
			else {
				result = currency = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public BigDecimal getLevelPercentage() {
			return levelPercentage;
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
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver() {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PartyReferencePayerReceiver.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getPaymentDate() {
			return paymentDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreatePaymentDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (paymentDate!=null) {
				result = paymentDate;
			}
			else {
				result = paymentDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		public TimeTypeEnum getTime() {
			return time;
		}
		
	
		@Override
		public FeaturePayment.FeaturePaymentBuilder setAmount(BigDecimal amount) {
			this.amount = amount==null?null:amount;
			return this;
		}
		@Override
		public FeaturePayment.FeaturePaymentBuilder setCurrency(FieldWithMetaString currency) {
			this.currency = currency==null?null:currency.toBuilder();
			return this;
		}
		
		@Override
		public FeaturePayment.FeaturePaymentBuilder setCurrencyValue(String currency) {
			this.getOrCreateCurrency().setValue(currency);
			return this;
		}
		@Override
		public FeaturePayment.FeaturePaymentBuilder setLevelPercentage(BigDecimal levelPercentage) {
			this.levelPercentage = levelPercentage==null?null:levelPercentage;
			return this;
		}
		@Override
		public FeaturePayment.FeaturePaymentBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FeaturePayment.FeaturePaymentBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public FeaturePayment.FeaturePaymentBuilder setPaymentDate(AdjustableOrRelativeDate paymentDate) {
			this.paymentDate = paymentDate==null?null:paymentDate.toBuilder();
			return this;
		}
		@Override
		public FeaturePayment.FeaturePaymentBuilder setTime(TimeTypeEnum time) {
			this.time = time==null?null:time;
			return this;
		}
		
		@Override
		public FeaturePayment build() {
			return new FeaturePayment.FeaturePaymentImpl(this);
		}
		
		@Override
		public FeaturePayment.FeaturePaymentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeaturePayment.FeaturePaymentBuilder prune() {
			if (currency!=null && !currency.prune().hasData()) currency = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			if (paymentDate!=null && !paymentDate.prune().hasData()) paymentDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getLevelPercentage()!=null) return true;
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			if (getPaymentDate()!=null && getPaymentDate().hasData()) return true;
			if (getTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FeaturePayment.FeaturePaymentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FeaturePayment.FeaturePaymentBuilder o = (FeaturePayment.FeaturePaymentBuilder) other;
			
			merger.mergeRosetta(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			merger.mergeRosetta(getPaymentDate(), o.getPaymentDate(), this::setPaymentDate);
			
			merger.mergeBasic(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeBasic(getLevelPercentage(), o.getLevelPercentage(), this::setLevelPercentage);
			merger.mergeBasic(getTime(), o.getTime(), this::setTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FeaturePayment _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(levelPercentage, _that.getLevelPercentage())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			if (!Objects.equals(paymentDate, _that.getPaymentDate())) return false;
			if (!Objects.equals(time, _that.getTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.hashCode() : 0);
			_result = 31 * _result + (levelPercentage != null ? levelPercentage.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			_result = 31 * _result + (paymentDate != null ? paymentDate.hashCode() : 0);
			_result = 31 * _result + (time != null ? time.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FeaturePaymentBuilder {" +
				"amount=" + this.amount + ", " +
				"currency=" + this.currency + ", " +
				"levelPercentage=" + this.levelPercentage + ", " +
				"meta=" + this.meta + ", " +
				"payerReceiver=" + this.payerReceiver + ", " +
				"paymentDate=" + this.paymentDate + ", " +
				"time=" + this.time +
			'}';
		}
	}
}
