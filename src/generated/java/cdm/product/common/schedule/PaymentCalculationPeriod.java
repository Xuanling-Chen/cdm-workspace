package cdm.product.common.schedule;

import cdm.observable.asset.Money;
import cdm.product.common.schedule.meta.PaymentCalculationPeriodMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.util.ListEquals;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A data defining:  the adjusted payment date and associated calculation period parameters required to calculate the actual or projected payment amount. This data forms:  part of the cashflow representation of a swap stream.
 * @version ${project.version}
 */
@RosettaClass

public interface PaymentCalculationPeriod extends RosettaModelObject, GlobalKey {
	PaymentCalculationPeriod build();
	PaymentCalculationPeriod.PaymentCalculationPeriodBuilder toBuilder();
	
	/**
	 * The adjusted payment date. This date should already be adjusted for any applicable business day convention. This component is not intended for use in trade confirmation but may be specified to allow the fee structure to also serve as a cashflow type component.
	 */
	Date getAdjustedPaymentDate();
	/**
	 * The parameters used in the calculation of a fixed or floating rate calculation period amount. A list of calculation period elements may be ordered in the document by ascending start date. An FpML document which contains an unordered list of calculation periods is still regarded as a conformant document.
	 */
	List<? extends CalculationPeriod> getCalculationPeriod();
	/**
	 * A decimal value representing the discount factor used to calculate the present value of cash flow.
	 */
	BigDecimal getDiscountFactor();
	/**
	 * A known fixed payment amount.
	 */
	BigDecimal getFixedPaymentAmount();
	/**
	 * A monetary amount representing the forecast of the future value of the payment.
	 */
	Money getForecastPaymentAmount();
	/**
	 */
	MetaFields getMeta();
	/**
	 * A monetary amount representing the present value of the forecast payment.
	 */
	Money getPresentValueAmount();
	/**
	 * The unadjusted payment date.
	 */
	Date getUnadjustedPaymentDate();
	final static PaymentCalculationPeriodMeta metaData = new PaymentCalculationPeriodMeta();
	
	@Override
	default RosettaMetaData<? extends PaymentCalculationPeriod> metaData() {
		return metaData;
	} 
			
	static PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder() {
		return new PaymentCalculationPeriod.PaymentCalculationPeriodBuilderImpl();
	}
	
	default Class<? extends PaymentCalculationPeriod> getType() {
		return PaymentCalculationPeriod.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
		processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
		processor.processBasic(path.newSubPath("fixedPaymentAmount"), BigDecimal.class, getFixedPaymentAmount(), this);
		processor.processBasic(path.newSubPath("unadjustedPaymentDate"), Date.class, getUnadjustedPaymentDate(), this);
		
		processRosetta(path.newSubPath("calculationPeriod"), processor, CalculationPeriod.class, getCalculationPeriod());
		processRosetta(path.newSubPath("forecastPaymentAmount"), processor, Money.class, getForecastPaymentAmount());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("presentValueAmount"), processor, Money.class, getPresentValueAmount());
	}
	
	
	interface PaymentCalculationPeriodBuilder extends PaymentCalculationPeriod, RosettaModelObjectBuilder {
		CalculationPeriod.CalculationPeriodBuilder getOrCreateCalculationPeriod(int _index);
		List<? extends CalculationPeriod.CalculationPeriodBuilder> getCalculationPeriod();
		Money.MoneyBuilder getOrCreateForecastPaymentAmount();
		Money.MoneyBuilder getForecastPaymentAmount();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Money.MoneyBuilder getOrCreatePresentValueAmount();
		Money.MoneyBuilder getPresentValueAmount();
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setAdjustedPaymentDate(Date adjustedPaymentDate);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod, int _idx);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(List<? extends CalculationPeriod> calculationPeriod);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setCalculationPeriod(List<? extends CalculationPeriod> calculationPeriod);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setDiscountFactor(BigDecimal discountFactor);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setFixedPaymentAmount(BigDecimal fixedPaymentAmount);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setForecastPaymentAmount(Money forecastPaymentAmount);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setMeta(MetaFields meta);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setPresentValueAmount(Money presentValueAmount);
		PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setUnadjustedPaymentDate(Date unadjustedPaymentDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("adjustedPaymentDate"), Date.class, getAdjustedPaymentDate(), this);
			processor.processBasic(path.newSubPath("discountFactor"), BigDecimal.class, getDiscountFactor(), this);
			processor.processBasic(path.newSubPath("fixedPaymentAmount"), BigDecimal.class, getFixedPaymentAmount(), this);
			processor.processBasic(path.newSubPath("unadjustedPaymentDate"), Date.class, getUnadjustedPaymentDate(), this);
			
			processRosetta(path.newSubPath("calculationPeriod"), processor, CalculationPeriod.CalculationPeriodBuilder.class, getCalculationPeriod());
			processRosetta(path.newSubPath("forecastPaymentAmount"), processor, Money.MoneyBuilder.class, getForecastPaymentAmount());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("presentValueAmount"), processor, Money.MoneyBuilder.class, getPresentValueAmount());
		}
		
	}
	
	//PaymentCalculationPeriod.PaymentCalculationPeriodImpl
	class PaymentCalculationPeriodImpl implements PaymentCalculationPeriod {
		private final Date adjustedPaymentDate;
		private final List<? extends CalculationPeriod> calculationPeriod;
		private final BigDecimal discountFactor;
		private final BigDecimal fixedPaymentAmount;
		private final Money forecastPaymentAmount;
		private final MetaFields meta;
		private final Money presentValueAmount;
		private final Date unadjustedPaymentDate;
		
		protected PaymentCalculationPeriodImpl(PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder) {
			this.adjustedPaymentDate = builder.getAdjustedPaymentDate();
			this.calculationPeriod = ofNullable(builder.getCalculationPeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.discountFactor = builder.getDiscountFactor();
			this.fixedPaymentAmount = builder.getFixedPaymentAmount();
			this.forecastPaymentAmount = ofNullable(builder.getForecastPaymentAmount()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.presentValueAmount = ofNullable(builder.getPresentValueAmount()).map(f->f.build()).orElse(null);
			this.unadjustedPaymentDate = builder.getUnadjustedPaymentDate();
		}
		
		@Override
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		public List<? extends CalculationPeriod> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		@Override
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		public BigDecimal getFixedPaymentAmount() {
			return fixedPaymentAmount;
		}
		
		@Override
		public Money getForecastPaymentAmount() {
			return forecastPaymentAmount;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Money getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public Date getUnadjustedPaymentDate() {
			return unadjustedPaymentDate;
		}
		
		@Override
		public PaymentCalculationPeriod build() {
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder toBuilder() {
			PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PaymentCalculationPeriod.PaymentCalculationPeriodBuilder builder) {
			ofNullable(getAdjustedPaymentDate()).ifPresent(builder::setAdjustedPaymentDate);
			ofNullable(getCalculationPeriod()).ifPresent(builder::setCalculationPeriod);
			ofNullable(getDiscountFactor()).ifPresent(builder::setDiscountFactor);
			ofNullable(getFixedPaymentAmount()).ifPresent(builder::setFixedPaymentAmount);
			ofNullable(getForecastPaymentAmount()).ifPresent(builder::setForecastPaymentAmount);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getPresentValueAmount()).ifPresent(builder::setPresentValueAmount);
			ofNullable(getUnadjustedPaymentDate()).ifPresent(builder::setUnadjustedPaymentDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(fixedPaymentAmount, _that.getFixedPaymentAmount())) return false;
			if (!Objects.equals(forecastPaymentAmount, _that.getForecastPaymentAmount())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			if (!Objects.equals(unadjustedPaymentDate, _that.getUnadjustedPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (fixedPaymentAmount != null ? fixedPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (forecastPaymentAmount != null ? forecastPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			_result = 31 * _result + (unadjustedPaymentDate != null ? unadjustedPaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentCalculationPeriod {" +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"fixedPaymentAmount=" + this.fixedPaymentAmount + ", " +
				"forecastPaymentAmount=" + this.forecastPaymentAmount + ", " +
				"meta=" + this.meta + ", " +
				"presentValueAmount=" + this.presentValueAmount + ", " +
				"unadjustedPaymentDate=" + this.unadjustedPaymentDate +
			'}';
		}
	}
	
	//PaymentCalculationPeriod.PaymentCalculationPeriodBuilderImpl
	class PaymentCalculationPeriodBuilderImpl implements PaymentCalculationPeriod.PaymentCalculationPeriodBuilder, GlobalKeyBuilder {
	
		protected Date adjustedPaymentDate;
		protected List<CalculationPeriod.CalculationPeriodBuilder> calculationPeriod = new ArrayList<>();
		protected BigDecimal discountFactor;
		protected BigDecimal fixedPaymentAmount;
		protected Money.MoneyBuilder forecastPaymentAmount;
		protected MetaFields.MetaFieldsBuilder meta;
		protected Money.MoneyBuilder presentValueAmount;
		protected Date unadjustedPaymentDate;
	
		public PaymentCalculationPeriodBuilderImpl() {
		}
	
		@Override
		public Date getAdjustedPaymentDate() {
			return adjustedPaymentDate;
		}
		
		@Override
		public List<? extends CalculationPeriod.CalculationPeriodBuilder> getCalculationPeriod() {
			return calculationPeriod;
		}
		
		public CalculationPeriod.CalculationPeriodBuilder getOrCreateCalculationPeriod(int _index) {
		
			if (calculationPeriod==null) {
				this.calculationPeriod = new ArrayList<>();
			}
			CalculationPeriod.CalculationPeriodBuilder result;
			return getIndex(calculationPeriod, _index, () -> {
						CalculationPeriod.CalculationPeriodBuilder newCalculationPeriod = CalculationPeriod.builder();
						return newCalculationPeriod;
					});
		}
		
		@Override
		public BigDecimal getDiscountFactor() {
			return discountFactor;
		}
		
		@Override
		public BigDecimal getFixedPaymentAmount() {
			return fixedPaymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getForecastPaymentAmount() {
			return forecastPaymentAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateForecastPaymentAmount() {
			Money.MoneyBuilder result;
			if (forecastPaymentAmount!=null) {
				result = forecastPaymentAmount;
			}
			else {
				result = forecastPaymentAmount = Money.builder();
			}
			
			return result;
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
		public Money.MoneyBuilder getPresentValueAmount() {
			return presentValueAmount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreatePresentValueAmount() {
			Money.MoneyBuilder result;
			if (presentValueAmount!=null) {
				result = presentValueAmount;
			}
			else {
				result = presentValueAmount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getUnadjustedPaymentDate() {
			return unadjustedPaymentDate;
		}
		
	
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setAdjustedPaymentDate(Date adjustedPaymentDate) {
			this.adjustedPaymentDate = adjustedPaymentDate==null?null:adjustedPaymentDate;
			return this;
		}
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod) {
			if (calculationPeriod!=null) this.calculationPeriod.add(calculationPeriod.toBuilder());
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(CalculationPeriod calculationPeriod, int _idx) {
			getIndex(this.calculationPeriod, _idx, () -> calculationPeriod.toBuilder());
			return this;
		}
		@Override 
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder addCalculationPeriod(List<? extends CalculationPeriod> calculationPeriods) {
			if (calculationPeriods != null) {
				for (CalculationPeriod toAdd : calculationPeriods) {
					this.calculationPeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setCalculationPeriod(List<? extends CalculationPeriod> calculationPeriods) {
			if (calculationPeriods == null)  {
				this.calculationPeriod = new ArrayList<>();
			}
			else {
				this.calculationPeriod = calculationPeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setDiscountFactor(BigDecimal discountFactor) {
			this.discountFactor = discountFactor==null?null:discountFactor;
			return this;
		}
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setFixedPaymentAmount(BigDecimal fixedPaymentAmount) {
			this.fixedPaymentAmount = fixedPaymentAmount==null?null:fixedPaymentAmount;
			return this;
		}
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setForecastPaymentAmount(Money forecastPaymentAmount) {
			this.forecastPaymentAmount = forecastPaymentAmount==null?null:forecastPaymentAmount.toBuilder();
			return this;
		}
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setPresentValueAmount(Money presentValueAmount) {
			this.presentValueAmount = presentValueAmount==null?null:presentValueAmount.toBuilder();
			return this;
		}
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder setUnadjustedPaymentDate(Date unadjustedPaymentDate) {
			this.unadjustedPaymentDate = unadjustedPaymentDate==null?null:unadjustedPaymentDate;
			return this;
		}
		
		@Override
		public PaymentCalculationPeriod build() {
			return new PaymentCalculationPeriod.PaymentCalculationPeriodImpl(this);
		}
		
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder prune() {
			calculationPeriod = calculationPeriod.stream().filter(b->b!=null).<CalculationPeriod.CalculationPeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (forecastPaymentAmount!=null && !forecastPaymentAmount.prune().hasData()) forecastPaymentAmount = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (presentValueAmount!=null && !presentValueAmount.prune().hasData()) presentValueAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustedPaymentDate()!=null) return true;
			if (getCalculationPeriod()!=null && getCalculationPeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDiscountFactor()!=null) return true;
			if (getFixedPaymentAmount()!=null) return true;
			if (getForecastPaymentAmount()!=null && getForecastPaymentAmount().hasData()) return true;
			if (getPresentValueAmount()!=null && getPresentValueAmount().hasData()) return true;
			if (getUnadjustedPaymentDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PaymentCalculationPeriod.PaymentCalculationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PaymentCalculationPeriod.PaymentCalculationPeriodBuilder o = (PaymentCalculationPeriod.PaymentCalculationPeriodBuilder) other;
			
			merger.mergeRosetta(getCalculationPeriod(), o.getCalculationPeriod(), this::getOrCreateCalculationPeriod);
			merger.mergeRosetta(getForecastPaymentAmount(), o.getForecastPaymentAmount(), this::setForecastPaymentAmount);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getPresentValueAmount(), o.getPresentValueAmount(), this::setPresentValueAmount);
			
			merger.mergeBasic(getAdjustedPaymentDate(), o.getAdjustedPaymentDate(), this::setAdjustedPaymentDate);
			merger.mergeBasic(getDiscountFactor(), o.getDiscountFactor(), this::setDiscountFactor);
			merger.mergeBasic(getFixedPaymentAmount(), o.getFixedPaymentAmount(), this::setFixedPaymentAmount);
			merger.mergeBasic(getUnadjustedPaymentDate(), o.getUnadjustedPaymentDate(), this::setUnadjustedPaymentDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PaymentCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(adjustedPaymentDate, _that.getAdjustedPaymentDate())) return false;
			if (!ListEquals.listEquals(calculationPeriod, _that.getCalculationPeriod())) return false;
			if (!Objects.equals(discountFactor, _that.getDiscountFactor())) return false;
			if (!Objects.equals(fixedPaymentAmount, _that.getFixedPaymentAmount())) return false;
			if (!Objects.equals(forecastPaymentAmount, _that.getForecastPaymentAmount())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(presentValueAmount, _that.getPresentValueAmount())) return false;
			if (!Objects.equals(unadjustedPaymentDate, _that.getUnadjustedPaymentDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustedPaymentDate != null ? adjustedPaymentDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriod != null ? calculationPeriod.hashCode() : 0);
			_result = 31 * _result + (discountFactor != null ? discountFactor.hashCode() : 0);
			_result = 31 * _result + (fixedPaymentAmount != null ? fixedPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (forecastPaymentAmount != null ? forecastPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (presentValueAmount != null ? presentValueAmount.hashCode() : 0);
			_result = 31 * _result + (unadjustedPaymentDate != null ? unadjustedPaymentDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PaymentCalculationPeriodBuilder {" +
				"adjustedPaymentDate=" + this.adjustedPaymentDate + ", " +
				"calculationPeriod=" + this.calculationPeriod + ", " +
				"discountFactor=" + this.discountFactor + ", " +
				"fixedPaymentAmount=" + this.fixedPaymentAmount + ", " +
				"forecastPaymentAmount=" + this.forecastPaymentAmount + ", " +
				"meta=" + this.meta + ", " +
				"presentValueAmount=" + this.presentValueAmount + ", " +
				"unadjustedPaymentDate=" + this.unadjustedPaymentDate +
			'}';
		}
	}
}
