package cdm.product.common.settlement;

import cdm.base.datetime.AdjustableDates;
import cdm.base.datetime.RelativeDateOffset;
import cdm.observable.asset.MultipleValuationDates;
import cdm.observable.asset.SingleValuationDate;
import cdm.product.common.settlement.meta.ValuationDateMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A single object that represents the different methods to specify a valuation date, as used for cash settlement. The Single / Multiple ValuationDate is used for the determination of recovery in a credit event, the RelativeDateOffset is used for cash-settled option, and FxFixingDate is used for cross-currency settlement.
 * @version ${project.version}
 */
@RosettaClass

public interface ValuationDate extends RosettaModelObject {
	ValuationDate build();
	ValuationDate.ValuationDateBuilder toBuilder();
	
	/**
	 * The date on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency. This attribute was formerly part of &#39;NonDeliverableSettlement&#39;, which is now being harmonised into a common &#39;CashSettlementTerms&#39; that includes a &#39;ValuationDate&#39;.
	 */
	FxFixingDate getFxFixingDate();
	/**
	 * The date, when expressed as a schedule of date(s), on which the currency rate will be determined for the purpose of specifying the amount in deliverable currency. This attribute was formerly part of &#39;NonDeliverableSettlement&#39;, which is now being harmonised into a common &#39;CashSettlementTerms&#39; that includes a &#39;ValuationDate&#39;.
	 */
	AdjustableDates getFxFixingSchedule();
	/**
	 * Where multiple valuation dates are specified as being applicable for cash settlement, this element specifies (a) the number of applicable valuation dates, and (b) the number of business days after satisfaction of all conditions to settlement when the first such valuation date occurs, and (c) the number of business days thereafter of each successive valuation date. ISDA 2003 Term: Multiple Valuation Dates.
	 */
	MultipleValuationDates getMultipleValuationDates();
	/**
	 * Where single valuation date is specified as being applicable for cash settlement, this element specifies the number of business days after satisfaction of all conditions to settlement when such valuation date occurs. ISDA 2003 Term: Single Valuation Date.
	 */
	SingleValuationDate getSingleValuationDate();
	/**
	 * The date on which the cash settlement amount will be determined according to the cash settlement method if the parties have not otherwise been able to agree the cash settlement amount. This attribute was formerly part of &#39;OptionCashSettlement&#39;, which is now being harmonised into a common &#39;CashSettlementTerms&#39; that includes a &#39;ValuationDate&#39;.
	 */
	RelativeDateOffset getValuationDate();
	final static ValuationDateMeta metaData = new ValuationDateMeta();
	
	@Override
	default RosettaMetaData<? extends ValuationDate> metaData() {
		return metaData;
	} 
			
	static ValuationDate.ValuationDateBuilder builder() {
		return new ValuationDate.ValuationDateBuilderImpl();
	}
	
	default Class<? extends ValuationDate> getType() {
		return ValuationDate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("fxFixingDate"), processor, FxFixingDate.class, getFxFixingDate());
		processRosetta(path.newSubPath("fxFixingSchedule"), processor, AdjustableDates.class, getFxFixingSchedule());
		processRosetta(path.newSubPath("multipleValuationDates"), processor, MultipleValuationDates.class, getMultipleValuationDates());
		processRosetta(path.newSubPath("singleValuationDate"), processor, SingleValuationDate.class, getSingleValuationDate());
		processRosetta(path.newSubPath("valuationDate"), processor, RelativeDateOffset.class, getValuationDate());
	}
	
	
	interface ValuationDateBuilder extends ValuationDate, RosettaModelObjectBuilder {
		FxFixingDate.FxFixingDateBuilder getOrCreateFxFixingDate();
		FxFixingDate.FxFixingDateBuilder getFxFixingDate();
		AdjustableDates.AdjustableDatesBuilder getOrCreateFxFixingSchedule();
		AdjustableDates.AdjustableDatesBuilder getFxFixingSchedule();
		MultipleValuationDates.MultipleValuationDatesBuilder getOrCreateMultipleValuationDates();
		MultipleValuationDates.MultipleValuationDatesBuilder getMultipleValuationDates();
		SingleValuationDate.SingleValuationDateBuilder getOrCreateSingleValuationDate();
		SingleValuationDate.SingleValuationDateBuilder getSingleValuationDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateValuationDate();
		RelativeDateOffset.RelativeDateOffsetBuilder getValuationDate();
		ValuationDate.ValuationDateBuilder setFxFixingDate(FxFixingDate fxFixingDate);
		ValuationDate.ValuationDateBuilder setFxFixingSchedule(AdjustableDates fxFixingSchedule);
		ValuationDate.ValuationDateBuilder setMultipleValuationDates(MultipleValuationDates multipleValuationDates);
		ValuationDate.ValuationDateBuilder setSingleValuationDate(SingleValuationDate singleValuationDate);
		ValuationDate.ValuationDateBuilder setValuationDate(RelativeDateOffset valuationDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("fxFixingDate"), processor, FxFixingDate.FxFixingDateBuilder.class, getFxFixingDate());
			processRosetta(path.newSubPath("fxFixingSchedule"), processor, AdjustableDates.AdjustableDatesBuilder.class, getFxFixingSchedule());
			processRosetta(path.newSubPath("multipleValuationDates"), processor, MultipleValuationDates.MultipleValuationDatesBuilder.class, getMultipleValuationDates());
			processRosetta(path.newSubPath("singleValuationDate"), processor, SingleValuationDate.SingleValuationDateBuilder.class, getSingleValuationDate());
			processRosetta(path.newSubPath("valuationDate"), processor, RelativeDateOffset.RelativeDateOffsetBuilder.class, getValuationDate());
		}
		
	}
	
	//ValuationDate.ValuationDateImpl
	class ValuationDateImpl implements ValuationDate {
		private final FxFixingDate fxFixingDate;
		private final AdjustableDates fxFixingSchedule;
		private final MultipleValuationDates multipleValuationDates;
		private final SingleValuationDate singleValuationDate;
		private final RelativeDateOffset valuationDate;
		
		protected ValuationDateImpl(ValuationDate.ValuationDateBuilder builder) {
			this.fxFixingDate = ofNullable(builder.getFxFixingDate()).map(f->f.build()).orElse(null);
			this.fxFixingSchedule = ofNullable(builder.getFxFixingSchedule()).map(f->f.build()).orElse(null);
			this.multipleValuationDates = ofNullable(builder.getMultipleValuationDates()).map(f->f.build()).orElse(null);
			this.singleValuationDate = ofNullable(builder.getSingleValuationDate()).map(f->f.build()).orElse(null);
			this.valuationDate = ofNullable(builder.getValuationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FxFixingDate getFxFixingDate() {
			return fxFixingDate;
		}
		
		@Override
		public AdjustableDates getFxFixingSchedule() {
			return fxFixingSchedule;
		}
		
		@Override
		public MultipleValuationDates getMultipleValuationDates() {
			return multipleValuationDates;
		}
		
		@Override
		public SingleValuationDate getSingleValuationDate() {
			return singleValuationDate;
		}
		
		@Override
		public RelativeDateOffset getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public ValuationDate build() {
			return this;
		}
		
		@Override
		public ValuationDate.ValuationDateBuilder toBuilder() {
			ValuationDate.ValuationDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationDate.ValuationDateBuilder builder) {
			ofNullable(getFxFixingDate()).ifPresent(builder::setFxFixingDate);
			ofNullable(getFxFixingSchedule()).ifPresent(builder::setFxFixingSchedule);
			ofNullable(getMultipleValuationDates()).ifPresent(builder::setMultipleValuationDates);
			ofNullable(getSingleValuationDate()).ifPresent(builder::setSingleValuationDate);
			ofNullable(getValuationDate()).ifPresent(builder::setValuationDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(fxFixingDate, _that.getFxFixingDate())) return false;
			if (!Objects.equals(fxFixingSchedule, _that.getFxFixingSchedule())) return false;
			if (!Objects.equals(multipleValuationDates, _that.getMultipleValuationDates())) return false;
			if (!Objects.equals(singleValuationDate, _that.getSingleValuationDate())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFixingDate != null ? fxFixingDate.hashCode() : 0);
			_result = 31 * _result + (fxFixingSchedule != null ? fxFixingSchedule.hashCode() : 0);
			_result = 31 * _result + (multipleValuationDates != null ? multipleValuationDates.hashCode() : 0);
			_result = 31 * _result + (singleValuationDate != null ? singleValuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDate {" +
				"fxFixingDate=" + this.fxFixingDate + ", " +
				"fxFixingSchedule=" + this.fxFixingSchedule + ", " +
				"multipleValuationDates=" + this.multipleValuationDates + ", " +
				"singleValuationDate=" + this.singleValuationDate + ", " +
				"valuationDate=" + this.valuationDate +
			'}';
		}
	}
	
	//ValuationDate.ValuationDateBuilderImpl
	class ValuationDateBuilderImpl implements ValuationDate.ValuationDateBuilder {
	
		protected FxFixingDate.FxFixingDateBuilder fxFixingDate;
		protected AdjustableDates.AdjustableDatesBuilder fxFixingSchedule;
		protected MultipleValuationDates.MultipleValuationDatesBuilder multipleValuationDates;
		protected SingleValuationDate.SingleValuationDateBuilder singleValuationDate;
		protected RelativeDateOffset.RelativeDateOffsetBuilder valuationDate;
	
		public ValuationDateBuilderImpl() {
		}
	
		@Override
		public FxFixingDate.FxFixingDateBuilder getFxFixingDate() {
			return fxFixingDate;
		}
		
		@Override
		public FxFixingDate.FxFixingDateBuilder getOrCreateFxFixingDate() {
			FxFixingDate.FxFixingDateBuilder result;
			if (fxFixingDate!=null) {
				result = fxFixingDate;
			}
			else {
				result = fxFixingDate = FxFixingDate.builder();
			}
			
			return result;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getFxFixingSchedule() {
			return fxFixingSchedule;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateFxFixingSchedule() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (fxFixingSchedule!=null) {
				result = fxFixingSchedule;
			}
			else {
				result = fxFixingSchedule = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder getMultipleValuationDates() {
			return multipleValuationDates;
		}
		
		@Override
		public MultipleValuationDates.MultipleValuationDatesBuilder getOrCreateMultipleValuationDates() {
			MultipleValuationDates.MultipleValuationDatesBuilder result;
			if (multipleValuationDates!=null) {
				result = multipleValuationDates;
			}
			else {
				result = multipleValuationDates = MultipleValuationDates.builder();
			}
			
			return result;
		}
		
		@Override
		public SingleValuationDate.SingleValuationDateBuilder getSingleValuationDate() {
			return singleValuationDate;
		}
		
		@Override
		public SingleValuationDate.SingleValuationDateBuilder getOrCreateSingleValuationDate() {
			SingleValuationDate.SingleValuationDateBuilder result;
			if (singleValuationDate!=null) {
				result = singleValuationDate;
			}
			else {
				result = singleValuationDate = SingleValuationDate.builder();
			}
			
			return result;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getValuationDate() {
			return valuationDate;
		}
		
		@Override
		public RelativeDateOffset.RelativeDateOffsetBuilder getOrCreateValuationDate() {
			RelativeDateOffset.RelativeDateOffsetBuilder result;
			if (valuationDate!=null) {
				result = valuationDate;
			}
			else {
				result = valuationDate = RelativeDateOffset.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ValuationDate.ValuationDateBuilder setFxFixingDate(FxFixingDate fxFixingDate) {
			this.fxFixingDate = fxFixingDate==null?null:fxFixingDate.toBuilder();
			return this;
		}
		@Override
		public ValuationDate.ValuationDateBuilder setFxFixingSchedule(AdjustableDates fxFixingSchedule) {
			this.fxFixingSchedule = fxFixingSchedule==null?null:fxFixingSchedule.toBuilder();
			return this;
		}
		@Override
		public ValuationDate.ValuationDateBuilder setMultipleValuationDates(MultipleValuationDates multipleValuationDates) {
			this.multipleValuationDates = multipleValuationDates==null?null:multipleValuationDates.toBuilder();
			return this;
		}
		@Override
		public ValuationDate.ValuationDateBuilder setSingleValuationDate(SingleValuationDate singleValuationDate) {
			this.singleValuationDate = singleValuationDate==null?null:singleValuationDate.toBuilder();
			return this;
		}
		@Override
		public ValuationDate.ValuationDateBuilder setValuationDate(RelativeDateOffset valuationDate) {
			this.valuationDate = valuationDate==null?null:valuationDate.toBuilder();
			return this;
		}
		
		@Override
		public ValuationDate build() {
			return new ValuationDate.ValuationDateImpl(this);
		}
		
		@Override
		public ValuationDate.ValuationDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDate.ValuationDateBuilder prune() {
			if (fxFixingDate!=null && !fxFixingDate.prune().hasData()) fxFixingDate = null;
			if (fxFixingSchedule!=null && !fxFixingSchedule.prune().hasData()) fxFixingSchedule = null;
			if (multipleValuationDates!=null && !multipleValuationDates.prune().hasData()) multipleValuationDates = null;
			if (singleValuationDate!=null && !singleValuationDate.prune().hasData()) singleValuationDate = null;
			if (valuationDate!=null && !valuationDate.prune().hasData()) valuationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxFixingDate()!=null && getFxFixingDate().hasData()) return true;
			if (getFxFixingSchedule()!=null && getFxFixingSchedule().hasData()) return true;
			if (getMultipleValuationDates()!=null && getMultipleValuationDates().hasData()) return true;
			if (getSingleValuationDate()!=null && getSingleValuationDate().hasData()) return true;
			if (getValuationDate()!=null && getValuationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDate.ValuationDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationDate.ValuationDateBuilder o = (ValuationDate.ValuationDateBuilder) other;
			
			merger.mergeRosetta(getFxFixingDate(), o.getFxFixingDate(), this::setFxFixingDate);
			merger.mergeRosetta(getFxFixingSchedule(), o.getFxFixingSchedule(), this::setFxFixingSchedule);
			merger.mergeRosetta(getMultipleValuationDates(), o.getMultipleValuationDates(), this::setMultipleValuationDates);
			merger.mergeRosetta(getSingleValuationDate(), o.getSingleValuationDate(), this::setSingleValuationDate);
			merger.mergeRosetta(getValuationDate(), o.getValuationDate(), this::setValuationDate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationDate _that = getType().cast(o);
		
			if (!Objects.equals(fxFixingDate, _that.getFxFixingDate())) return false;
			if (!Objects.equals(fxFixingSchedule, _that.getFxFixingSchedule())) return false;
			if (!Objects.equals(multipleValuationDates, _that.getMultipleValuationDates())) return false;
			if (!Objects.equals(singleValuationDate, _that.getSingleValuationDate())) return false;
			if (!Objects.equals(valuationDate, _that.getValuationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFixingDate != null ? fxFixingDate.hashCode() : 0);
			_result = 31 * _result + (fxFixingSchedule != null ? fxFixingSchedule.hashCode() : 0);
			_result = 31 * _result + (multipleValuationDates != null ? multipleValuationDates.hashCode() : 0);
			_result = 31 * _result + (singleValuationDate != null ? singleValuationDate.hashCode() : 0);
			_result = 31 * _result + (valuationDate != null ? valuationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDateBuilder {" +
				"fxFixingDate=" + this.fxFixingDate + ", " +
				"fxFixingSchedule=" + this.fxFixingSchedule + ", " +
				"multipleValuationDates=" + this.multipleValuationDates + ", " +
				"singleValuationDate=" + this.singleValuationDate + ", " +
				"valuationDate=" + this.valuationDate +
			'}';
		}
	}
}
