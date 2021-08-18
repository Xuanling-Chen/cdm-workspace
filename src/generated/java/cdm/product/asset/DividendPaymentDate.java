package cdm.product.asset;

import cdm.base.datetime.AdjustableDate;
import cdm.product.asset.meta.DividendPaymentDateMeta;
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
 * A class describing the date on which the dividend will be paid/received. This class is also used to specify the date on which the FX rate will be determined, when applicable.
 * @version ${project.version}
 */
@RosettaClass

public interface DividendPaymentDate extends RosettaModelObject {
	DividendPaymentDate build();
	DividendPaymentDate.DividendPaymentDateBuilder toBuilder();
	
	/**
	 */
	AdjustableDate getAdjustableDate();
	/**
	 */
	DividendDateReference getDividendDateReference();
	final static DividendPaymentDateMeta metaData = new DividendPaymentDateMeta();
	
	@Override
	default RosettaMetaData<? extends DividendPaymentDate> metaData() {
		return metaData;
	} 
			
	static DividendPaymentDate.DividendPaymentDateBuilder builder() {
		return new DividendPaymentDate.DividendPaymentDateBuilderImpl();
	}
	
	default Class<? extends DividendPaymentDate> getType() {
		return DividendPaymentDate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.class, getAdjustableDate());
		processRosetta(path.newSubPath("dividendDateReference"), processor, DividendDateReference.class, getDividendDateReference());
	}
	
	
	interface DividendPaymentDateBuilder extends DividendPaymentDate, RosettaModelObjectBuilder {
		AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate();
		AdjustableDate.AdjustableDateBuilder getAdjustableDate();
		DividendDateReference.DividendDateReferenceBuilder getOrCreateDividendDateReference();
		DividendDateReference.DividendDateReferenceBuilder getDividendDateReference();
		DividendPaymentDate.DividendPaymentDateBuilder setAdjustableDate(AdjustableDate adjustableDate);
		DividendPaymentDate.DividendPaymentDateBuilder setDividendDateReference(DividendDateReference dividendDateReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("adjustableDate"), processor, AdjustableDate.AdjustableDateBuilder.class, getAdjustableDate());
			processRosetta(path.newSubPath("dividendDateReference"), processor, DividendDateReference.DividendDateReferenceBuilder.class, getDividendDateReference());
		}
		
	}
	
	//DividendPaymentDate.DividendPaymentDateImpl
	class DividendPaymentDateImpl implements DividendPaymentDate {
		private final AdjustableDate adjustableDate;
		private final DividendDateReference dividendDateReference;
		
		protected DividendPaymentDateImpl(DividendPaymentDate.DividendPaymentDateBuilder builder) {
			this.adjustableDate = ofNullable(builder.getAdjustableDate()).map(f->f.build()).orElse(null);
			this.dividendDateReference = ofNullable(builder.getDividendDateReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AdjustableDate getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public DividendDateReference getDividendDateReference() {
			return dividendDateReference;
		}
		
		@Override
		public DividendPaymentDate build() {
			return this;
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder toBuilder() {
			DividendPaymentDate.DividendPaymentDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendPaymentDate.DividendPaymentDateBuilder builder) {
			ofNullable(getAdjustableDate()).ifPresent(builder::setAdjustableDate);
			ofNullable(getDividendDateReference()).ifPresent(builder::setDividendDateReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(dividendDateReference, _that.getDividendDateReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (dividendDateReference != null ? dividendDateReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPaymentDate {" +
				"adjustableDate=" + this.adjustableDate + ", " +
				"dividendDateReference=" + this.dividendDateReference +
			'}';
		}
	}
	
	//DividendPaymentDate.DividendPaymentDateBuilderImpl
	class DividendPaymentDateBuilderImpl implements DividendPaymentDate.DividendPaymentDateBuilder {
	
		protected AdjustableDate.AdjustableDateBuilder adjustableDate;
		protected DividendDateReference.DividendDateReferenceBuilder dividendDateReference;
	
		public DividendPaymentDateBuilderImpl() {
		}
	
		@Override
		public AdjustableDate.AdjustableDateBuilder getAdjustableDate() {
			return adjustableDate;
		}
		
		@Override
		public AdjustableDate.AdjustableDateBuilder getOrCreateAdjustableDate() {
			AdjustableDate.AdjustableDateBuilder result;
			if (adjustableDate!=null) {
				result = adjustableDate;
			}
			else {
				result = adjustableDate = AdjustableDate.builder();
			}
			
			return result;
		}
		
		@Override
		public DividendDateReference.DividendDateReferenceBuilder getDividendDateReference() {
			return dividendDateReference;
		}
		
		@Override
		public DividendDateReference.DividendDateReferenceBuilder getOrCreateDividendDateReference() {
			DividendDateReference.DividendDateReferenceBuilder result;
			if (dividendDateReference!=null) {
				result = dividendDateReference;
			}
			else {
				result = dividendDateReference = DividendDateReference.builder();
			}
			
			return result;
		}
		
	
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder setAdjustableDate(AdjustableDate adjustableDate) {
			this.adjustableDate = adjustableDate==null?null:adjustableDate.toBuilder();
			return this;
		}
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder setDividendDateReference(DividendDateReference dividendDateReference) {
			this.dividendDateReference = dividendDateReference==null?null:dividendDateReference.toBuilder();
			return this;
		}
		
		@Override
		public DividendPaymentDate build() {
			return new DividendPaymentDate.DividendPaymentDateImpl(this);
		}
		
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder prune() {
			if (adjustableDate!=null && !adjustableDate.prune().hasData()) adjustableDate = null;
			if (dividendDateReference!=null && !dividendDateReference.prune().hasData()) dividendDateReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDate()!=null && getAdjustableDate().hasData()) return true;
			if (getDividendDateReference()!=null && getDividendDateReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendPaymentDate.DividendPaymentDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DividendPaymentDate.DividendPaymentDateBuilder o = (DividendPaymentDate.DividendPaymentDateBuilder) other;
			
			merger.mergeRosetta(getAdjustableDate(), o.getAdjustableDate(), this::setAdjustableDate);
			merger.mergeRosetta(getDividendDateReference(), o.getDividendDateReference(), this::setDividendDateReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DividendPaymentDate _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDate, _that.getAdjustableDate())) return false;
			if (!Objects.equals(dividendDateReference, _that.getDividendDateReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDate != null ? adjustableDate.hashCode() : 0);
			_result = 31 * _result + (dividendDateReference != null ? dividendDateReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendPaymentDateBuilder {" +
				"adjustableDate=" + this.adjustableDate + ", " +
				"dividendDateReference=" + this.dividendDateReference +
			'}';
		}
	}
}
