package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.BespokeCalculationDateMeta;
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
 * A class to specify bespoke Calculation Date terms for the purposes of Initial Margin
 * @version ${project.version}
 */
@RosettaClass

public interface BespokeCalculationDate extends RosettaModelObject {
	BespokeCalculationDate build();
	BespokeCalculationDate.BespokeCalculationDateBuilder toBuilder();
	
	/**
	 * The Additional Calculation Date terms for the purposes of Initial Margin
	 */
	String getCalculationDateImTerms();
	/**
	 * Additional Calculation Date terms are applicable when True and not applicable when False
	 */
	Boolean getIsApplicable();
	final static BespokeCalculationDateMeta metaData = new BespokeCalculationDateMeta();
	
	@Override
	default RosettaMetaData<? extends BespokeCalculationDate> metaData() {
		return metaData;
	} 
			
	static BespokeCalculationDate.BespokeCalculationDateBuilder builder() {
		return new BespokeCalculationDate.BespokeCalculationDateBuilderImpl();
	}
	
	default Class<? extends BespokeCalculationDate> getType() {
		return BespokeCalculationDate.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("calculationDateImTerms"), String.class, getCalculationDateImTerms(), this);
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		
	}
	
	
	interface BespokeCalculationDateBuilder extends BespokeCalculationDate, RosettaModelObjectBuilder {
		BespokeCalculationDate.BespokeCalculationDateBuilder setCalculationDateImTerms(String calculationDateImTerms);
		BespokeCalculationDate.BespokeCalculationDateBuilder setIsApplicable(Boolean isApplicable);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("calculationDateImTerms"), String.class, getCalculationDateImTerms(), this);
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			
		}
		
	}
	
	//BespokeCalculationDate.BespokeCalculationDateImpl
	class BespokeCalculationDateImpl implements BespokeCalculationDate {
		private final String calculationDateImTerms;
		private final Boolean isApplicable;
		
		protected BespokeCalculationDateImpl(BespokeCalculationDate.BespokeCalculationDateBuilder builder) {
			this.calculationDateImTerms = builder.getCalculationDateImTerms();
			this.isApplicable = builder.getIsApplicable();
		}
		
		@Override
		public String getCalculationDateImTerms() {
			return calculationDateImTerms;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public BespokeCalculationDate build() {
			return this;
		}
		
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder toBuilder() {
			BespokeCalculationDate.BespokeCalculationDateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BespokeCalculationDate.BespokeCalculationDateBuilder builder) {
			ofNullable(getCalculationDateImTerms()).ifPresent(builder::setCalculationDateImTerms);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeCalculationDate _that = getType().cast(o);
		
			if (!Objects.equals(calculationDateImTerms, _that.getCalculationDateImTerms())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDateImTerms != null ? calculationDateImTerms.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeCalculationDate {" +
				"calculationDateImTerms=" + this.calculationDateImTerms + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
	
	//BespokeCalculationDate.BespokeCalculationDateBuilderImpl
	class BespokeCalculationDateBuilderImpl implements BespokeCalculationDate.BespokeCalculationDateBuilder {
	
		protected String calculationDateImTerms;
		protected Boolean isApplicable;
	
		public BespokeCalculationDateBuilderImpl() {
		}
	
		@Override
		public String getCalculationDateImTerms() {
			return calculationDateImTerms;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
	
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder setCalculationDateImTerms(String calculationDateImTerms) {
			this.calculationDateImTerms = calculationDateImTerms==null?null:calculationDateImTerms;
			return this;
		}
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		
		@Override
		public BespokeCalculationDate build() {
			return new BespokeCalculationDate.BespokeCalculationDateImpl(this);
		}
		
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationDateImTerms()!=null) return true;
			if (getIsApplicable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeCalculationDate.BespokeCalculationDateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BespokeCalculationDate.BespokeCalculationDateBuilder o = (BespokeCalculationDate.BespokeCalculationDateBuilder) other;
			
			
			merger.mergeBasic(getCalculationDateImTerms(), o.getCalculationDateImTerms(), this::setCalculationDateImTerms);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeCalculationDate _that = getType().cast(o);
		
			if (!Objects.equals(calculationDateImTerms, _that.getCalculationDateImTerms())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationDateImTerms != null ? calculationDateImTerms.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeCalculationDateBuilder {" +
				"calculationDateImTerms=" + this.calculationDateImTerms + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
}
