package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.BespokeCalculationTimeMeta;
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
 * A class to specify additional Calculation Time terms for the purposes of Initial Margin
 * @version ${project.version}
 */
@RosettaClass

public interface BespokeCalculationTime extends RosettaModelObject {
	BespokeCalculationTime build();
	BespokeCalculationTime.BespokeCalculationTimeBuilder toBuilder();
	
	/**
	 * If set to True, the Calculation Time for Initial Margin is the time as of which the Calculation Agent (IM) computes its end of day valuations of derivatives transactions
	 */
	Boolean getAsCalculationAgent();
	/**
	 * Additional Terms applicable to Calculation Time for Initial Margin
	 */
	String getBespokeCalculationTimeTerms();
	final static BespokeCalculationTimeMeta metaData = new BespokeCalculationTimeMeta();
	
	@Override
	default RosettaMetaData<? extends BespokeCalculationTime> metaData() {
		return metaData;
	} 
			
	static BespokeCalculationTime.BespokeCalculationTimeBuilder builder() {
		return new BespokeCalculationTime.BespokeCalculationTimeBuilderImpl();
	}
	
	default Class<? extends BespokeCalculationTime> getType() {
		return BespokeCalculationTime.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("asCalculationAgent"), Boolean.class, getAsCalculationAgent(), this);
		processor.processBasic(path.newSubPath("bespokeCalculationTimeTerms"), String.class, getBespokeCalculationTimeTerms(), this);
		
	}
	
	
	interface BespokeCalculationTimeBuilder extends BespokeCalculationTime, RosettaModelObjectBuilder {
		BespokeCalculationTime.BespokeCalculationTimeBuilder setAsCalculationAgent(Boolean asCalculationAgent);
		BespokeCalculationTime.BespokeCalculationTimeBuilder setBespokeCalculationTimeTerms(String bespokeCalculationTimeTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("asCalculationAgent"), Boolean.class, getAsCalculationAgent(), this);
			processor.processBasic(path.newSubPath("bespokeCalculationTimeTerms"), String.class, getBespokeCalculationTimeTerms(), this);
			
		}
		
	}
	
	//BespokeCalculationTime.BespokeCalculationTimeImpl
	class BespokeCalculationTimeImpl implements BespokeCalculationTime {
		private final Boolean asCalculationAgent;
		private final String bespokeCalculationTimeTerms;
		
		protected BespokeCalculationTimeImpl(BespokeCalculationTime.BespokeCalculationTimeBuilder builder) {
			this.asCalculationAgent = builder.getAsCalculationAgent();
			this.bespokeCalculationTimeTerms = builder.getBespokeCalculationTimeTerms();
		}
		
		@Override
		public Boolean getAsCalculationAgent() {
			return asCalculationAgent;
		}
		
		@Override
		public String getBespokeCalculationTimeTerms() {
			return bespokeCalculationTimeTerms;
		}
		
		@Override
		public BespokeCalculationTime build() {
			return this;
		}
		
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder toBuilder() {
			BespokeCalculationTime.BespokeCalculationTimeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BespokeCalculationTime.BespokeCalculationTimeBuilder builder) {
			ofNullable(getAsCalculationAgent()).ifPresent(builder::setAsCalculationAgent);
			ofNullable(getBespokeCalculationTimeTerms()).ifPresent(builder::setBespokeCalculationTimeTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeCalculationTime _that = getType().cast(o);
		
			if (!Objects.equals(asCalculationAgent, _that.getAsCalculationAgent())) return false;
			if (!Objects.equals(bespokeCalculationTimeTerms, _that.getBespokeCalculationTimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asCalculationAgent != null ? asCalculationAgent.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationTimeTerms != null ? bespokeCalculationTimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeCalculationTime {" +
				"asCalculationAgent=" + this.asCalculationAgent + ", " +
				"bespokeCalculationTimeTerms=" + this.bespokeCalculationTimeTerms +
			'}';
		}
	}
	
	//BespokeCalculationTime.BespokeCalculationTimeBuilderImpl
	class BespokeCalculationTimeBuilderImpl implements BespokeCalculationTime.BespokeCalculationTimeBuilder {
	
		protected Boolean asCalculationAgent;
		protected String bespokeCalculationTimeTerms;
	
		public BespokeCalculationTimeBuilderImpl() {
		}
	
		@Override
		public Boolean getAsCalculationAgent() {
			return asCalculationAgent;
		}
		
		@Override
		public String getBespokeCalculationTimeTerms() {
			return bespokeCalculationTimeTerms;
		}
		
	
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder setAsCalculationAgent(Boolean asCalculationAgent) {
			this.asCalculationAgent = asCalculationAgent==null?null:asCalculationAgent;
			return this;
		}
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder setBespokeCalculationTimeTerms(String bespokeCalculationTimeTerms) {
			this.bespokeCalculationTimeTerms = bespokeCalculationTimeTerms==null?null:bespokeCalculationTimeTerms;
			return this;
		}
		
		@Override
		public BespokeCalculationTime build() {
			return new BespokeCalculationTime.BespokeCalculationTimeImpl(this);
		}
		
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAsCalculationAgent()!=null) return true;
			if (getBespokeCalculationTimeTerms()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BespokeCalculationTime.BespokeCalculationTimeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BespokeCalculationTime.BespokeCalculationTimeBuilder o = (BespokeCalculationTime.BespokeCalculationTimeBuilder) other;
			
			
			merger.mergeBasic(getAsCalculationAgent(), o.getAsCalculationAgent(), this::setAsCalculationAgent);
			merger.mergeBasic(getBespokeCalculationTimeTerms(), o.getBespokeCalculationTimeTerms(), this::setBespokeCalculationTimeTerms);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BespokeCalculationTime _that = getType().cast(o);
		
			if (!Objects.equals(asCalculationAgent, _that.getAsCalculationAgent())) return false;
			if (!Objects.equals(bespokeCalculationTimeTerms, _that.getBespokeCalculationTimeTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (asCalculationAgent != null ? asCalculationAgent.hashCode() : 0);
			_result = 31 * _result + (bespokeCalculationTimeTerms != null ? bespokeCalculationTimeTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BespokeCalculationTimeBuilder {" +
				"asCalculationAgent=" + this.asCalculationAgent + ", " +
				"bespokeCalculationTimeTerms=" + this.bespokeCalculationTimeTerms +
			'}';
		}
	}
}
