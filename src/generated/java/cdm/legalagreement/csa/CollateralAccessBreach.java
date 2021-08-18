package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CollateralAccessBreachMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify Collateral Access Breach language
 * @version ${project.version}
 */
@RosettaClass

public interface CollateralAccessBreach extends RosettaModelObject {
	CollateralAccessBreach build();
	CollateralAccessBreach.CollateralAccessBreachBuilder toBuilder();
	
	/**
	 * The business days following the related Collateral Access Breach when the additional terms end 
	 */
	BigDecimal getCabEndDate();
	/**
	 * Determination of whether the Collateral Access Breach end date is a number of days (True) or specified (False)
	 */
	Boolean getCabEndDateElection();
	/**
	 * Specific terms for when Collateral Access Breach terms end
	 */
	String getCabEndDateTerms();
	/**
	 * Collateral Access Breach terms are applicable when True and not applicable when False
	 */
	Boolean getIsApplicable();
	final static CollateralAccessBreachMeta metaData = new CollateralAccessBreachMeta();
	
	@Override
	default RosettaMetaData<? extends CollateralAccessBreach> metaData() {
		return metaData;
	} 
			
	static CollateralAccessBreach.CollateralAccessBreachBuilder builder() {
		return new CollateralAccessBreach.CollateralAccessBreachBuilderImpl();
	}
	
	default Class<? extends CollateralAccessBreach> getType() {
		return CollateralAccessBreach.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("cabEndDate"), BigDecimal.class, getCabEndDate(), this);
		processor.processBasic(path.newSubPath("cabEndDateElection"), Boolean.class, getCabEndDateElection(), this);
		processor.processBasic(path.newSubPath("cabEndDateTerms"), String.class, getCabEndDateTerms(), this);
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		
	}
	
	
	interface CollateralAccessBreachBuilder extends CollateralAccessBreach, RosettaModelObjectBuilder {
		CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDate(BigDecimal cabEndDate);
		CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDateElection(Boolean cabEndDateElection);
		CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDateTerms(String cabEndDateTerms);
		CollateralAccessBreach.CollateralAccessBreachBuilder setIsApplicable(Boolean isApplicable);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("cabEndDate"), BigDecimal.class, getCabEndDate(), this);
			processor.processBasic(path.newSubPath("cabEndDateElection"), Boolean.class, getCabEndDateElection(), this);
			processor.processBasic(path.newSubPath("cabEndDateTerms"), String.class, getCabEndDateTerms(), this);
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			
		}
		
	}
	
	//CollateralAccessBreach.CollateralAccessBreachImpl
	class CollateralAccessBreachImpl implements CollateralAccessBreach {
		private final BigDecimal cabEndDate;
		private final Boolean cabEndDateElection;
		private final String cabEndDateTerms;
		private final Boolean isApplicable;
		
		protected CollateralAccessBreachImpl(CollateralAccessBreach.CollateralAccessBreachBuilder builder) {
			this.cabEndDate = builder.getCabEndDate();
			this.cabEndDateElection = builder.getCabEndDateElection();
			this.cabEndDateTerms = builder.getCabEndDateTerms();
			this.isApplicable = builder.getIsApplicable();
		}
		
		@Override
		public BigDecimal getCabEndDate() {
			return cabEndDate;
		}
		
		@Override
		public Boolean getCabEndDateElection() {
			return cabEndDateElection;
		}
		
		@Override
		public String getCabEndDateTerms() {
			return cabEndDateTerms;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public CollateralAccessBreach build() {
			return this;
		}
		
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder toBuilder() {
			CollateralAccessBreach.CollateralAccessBreachBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralAccessBreach.CollateralAccessBreachBuilder builder) {
			ofNullable(getCabEndDate()).ifPresent(builder::setCabEndDate);
			ofNullable(getCabEndDateElection()).ifPresent(builder::setCabEndDateElection);
			ofNullable(getCabEndDateTerms()).ifPresent(builder::setCabEndDateTerms);
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralAccessBreach _that = getType().cast(o);
		
			if (!Objects.equals(cabEndDate, _that.getCabEndDate())) return false;
			if (!Objects.equals(cabEndDateElection, _that.getCabEndDateElection())) return false;
			if (!Objects.equals(cabEndDateTerms, _that.getCabEndDateTerms())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cabEndDate != null ? cabEndDate.hashCode() : 0);
			_result = 31 * _result + (cabEndDateElection != null ? cabEndDateElection.hashCode() : 0);
			_result = 31 * _result + (cabEndDateTerms != null ? cabEndDateTerms.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralAccessBreach {" +
				"cabEndDate=" + this.cabEndDate + ", " +
				"cabEndDateElection=" + this.cabEndDateElection + ", " +
				"cabEndDateTerms=" + this.cabEndDateTerms + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
	
	//CollateralAccessBreach.CollateralAccessBreachBuilderImpl
	class CollateralAccessBreachBuilderImpl implements CollateralAccessBreach.CollateralAccessBreachBuilder {
	
		protected BigDecimal cabEndDate;
		protected Boolean cabEndDateElection;
		protected String cabEndDateTerms;
		protected Boolean isApplicable;
	
		public CollateralAccessBreachBuilderImpl() {
		}
	
		@Override
		public BigDecimal getCabEndDate() {
			return cabEndDate;
		}
		
		@Override
		public Boolean getCabEndDateElection() {
			return cabEndDateElection;
		}
		
		@Override
		public String getCabEndDateTerms() {
			return cabEndDateTerms;
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
	
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDate(BigDecimal cabEndDate) {
			this.cabEndDate = cabEndDate==null?null:cabEndDate;
			return this;
		}
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDateElection(Boolean cabEndDateElection) {
			this.cabEndDateElection = cabEndDateElection==null?null:cabEndDateElection;
			return this;
		}
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder setCabEndDateTerms(String cabEndDateTerms) {
			this.cabEndDateTerms = cabEndDateTerms==null?null:cabEndDateTerms;
			return this;
		}
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		
		@Override
		public CollateralAccessBreach build() {
			return new CollateralAccessBreach.CollateralAccessBreachImpl(this);
		}
		
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCabEndDate()!=null) return true;
			if (getCabEndDateElection()!=null) return true;
			if (getCabEndDateTerms()!=null) return true;
			if (getIsApplicable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralAccessBreach.CollateralAccessBreachBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralAccessBreach.CollateralAccessBreachBuilder o = (CollateralAccessBreach.CollateralAccessBreachBuilder) other;
			
			
			merger.mergeBasic(getCabEndDate(), o.getCabEndDate(), this::setCabEndDate);
			merger.mergeBasic(getCabEndDateElection(), o.getCabEndDateElection(), this::setCabEndDateElection);
			merger.mergeBasic(getCabEndDateTerms(), o.getCabEndDateTerms(), this::setCabEndDateTerms);
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralAccessBreach _that = getType().cast(o);
		
			if (!Objects.equals(cabEndDate, _that.getCabEndDate())) return false;
			if (!Objects.equals(cabEndDateElection, _that.getCabEndDateElection())) return false;
			if (!Objects.equals(cabEndDateTerms, _that.getCabEndDateTerms())) return false;
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (cabEndDate != null ? cabEndDate.hashCode() : 0);
			_result = 31 * _result + (cabEndDateElection != null ? cabEndDateElection.hashCode() : 0);
			_result = 31 * _result + (cabEndDateTerms != null ? cabEndDateTerms.hashCode() : 0);
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralAccessBreachBuilder {" +
				"cabEndDate=" + this.cabEndDate + ", " +
				"cabEndDateElection=" + this.cabEndDateElection + ", " +
				"cabEndDateTerms=" + this.cabEndDateTerms + ", " +
				"isApplicable=" + this.isApplicable +
			'}';
		}
	}
}
