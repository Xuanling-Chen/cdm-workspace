package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.AppropriatedCollateralValuationMeta;
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
 * A class to specify the Valuation of Appropriated Collateral that is applicable to the English Law ISDA CSA. ISDA 2016 English Law Credit Support Deed for Initial Margin, paragraph 13, General Principles, (u): Valuation of Appropriated Collateral.
 * @version ${project.version}
 */
@RosettaClass

public interface AppropriatedCollateralValuation extends RosettaModelObject {
	AppropriatedCollateralValuation build();
	AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder toBuilder();
	
	/**
	 * The parties&#39; election that qualify the Valuation of Appropriate Collateral in the case where it is deemed applicable.
	 */
	String getElection();
	/**
	 * The qualification of whether the Valuation of Appropriate Collateral provision is applicable (True) or not applicable (False).
	 */
	Boolean getIsSpecified();
	final static AppropriatedCollateralValuationMeta metaData = new AppropriatedCollateralValuationMeta();
	
	@Override
	default RosettaMetaData<? extends AppropriatedCollateralValuation> metaData() {
		return metaData;
	} 
			
	static AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder builder() {
		return new AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilderImpl();
	}
	
	default Class<? extends AppropriatedCollateralValuation> getType() {
		return AppropriatedCollateralValuation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("election"), String.class, getElection(), this);
		processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
		
	}
	
	
	interface AppropriatedCollateralValuationBuilder extends AppropriatedCollateralValuation, RosettaModelObjectBuilder {
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder setElection(String election);
		AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder setIsSpecified(Boolean isSpecified);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("election"), String.class, getElection(), this);
			processor.processBasic(path.newSubPath("isSpecified"), Boolean.class, getIsSpecified(), this);
			
		}
		
	}
	
	//AppropriatedCollateralValuation.AppropriatedCollateralValuationImpl
	class AppropriatedCollateralValuationImpl implements AppropriatedCollateralValuation {
		private final String election;
		private final Boolean isSpecified;
		
		protected AppropriatedCollateralValuationImpl(AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder builder) {
			this.election = builder.getElection();
			this.isSpecified = builder.getIsSpecified();
		}
		
		@Override
		public String getElection() {
			return election;
		}
		
		@Override
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
		@Override
		public AppropriatedCollateralValuation build() {
			return this;
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder toBuilder() {
			AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder builder) {
			ofNullable(getElection()).ifPresent(builder::setElection);
			ofNullable(getIsSpecified()).ifPresent(builder::setIsSpecified);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AppropriatedCollateralValuation _that = getType().cast(o);
		
			if (!Objects.equals(election, _that.getElection())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (election != null ? election.hashCode() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AppropriatedCollateralValuation {" +
				"election=" + this.election + ", " +
				"isSpecified=" + this.isSpecified +
			'}';
		}
	}
	
	//AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilderImpl
	class AppropriatedCollateralValuationBuilderImpl implements AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder {
	
		protected String election;
		protected Boolean isSpecified;
	
		public AppropriatedCollateralValuationBuilderImpl() {
		}
	
		@Override
		public String getElection() {
			return election;
		}
		
		@Override
		public Boolean getIsSpecified() {
			return isSpecified;
		}
		
	
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder setElection(String election) {
			this.election = election==null?null:election;
			return this;
		}
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder setIsSpecified(Boolean isSpecified) {
			this.isSpecified = isSpecified==null?null:isSpecified;
			return this;
		}
		
		@Override
		public AppropriatedCollateralValuation build() {
			return new AppropriatedCollateralValuation.AppropriatedCollateralValuationImpl(this);
		}
		
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getElection()!=null) return true;
			if (getIsSpecified()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder o = (AppropriatedCollateralValuation.AppropriatedCollateralValuationBuilder) other;
			
			
			merger.mergeBasic(getElection(), o.getElection(), this::setElection);
			merger.mergeBasic(getIsSpecified(), o.getIsSpecified(), this::setIsSpecified);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AppropriatedCollateralValuation _that = getType().cast(o);
		
			if (!Objects.equals(election, _that.getElection())) return false;
			if (!Objects.equals(isSpecified, _that.getIsSpecified())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (election != null ? election.hashCode() : 0);
			_result = 31 * _result + (isSpecified != null ? isSpecified.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AppropriatedCollateralValuationBuilder {" +
				"election=" + this.election + ", " +
				"isSpecified=" + this.isSpecified +
			'}';
		}
	}
}
