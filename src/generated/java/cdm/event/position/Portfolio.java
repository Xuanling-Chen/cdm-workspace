package cdm.event.position;

import cdm.event.position.meta.PortfolioMeta;
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
 *  A Portfolio represents an aggregation of multiple Positions, by describing the parameters that this Portfolio should be aggregated based on. The resulting PortfolioState is calculated using these aggregation parameters as inputs, by aggregating all the Events that are relevant to this Portfolio. The concept of Portfolio works at all levels in the model: from the highest for a given LegalEntity for instance, to the lowest to account for security substitutions in a secutity financing transaction. As such, Portfolio can be used either above or below the Contract level.
 * @version ${project.version}
 */
@RosettaClass

public interface Portfolio extends RosettaModelObject {
	Portfolio build();
	Portfolio.PortfolioBuilder toBuilder();
	
	/**
	 * Describes the portfolio by describing how to aggregate all its relevant Events.
	 */
	AggregationParameters getAggregationParameters();
	/**
	 * Describes the state of the Portfolio as a list of Positions resulting from the aggregation.
	 */
	PortfolioState getPortfolioState();
	final static PortfolioMeta metaData = new PortfolioMeta();
	
	@Override
	default RosettaMetaData<? extends Portfolio> metaData() {
		return metaData;
	} 
			
	static Portfolio.PortfolioBuilder builder() {
		return new Portfolio.PortfolioBuilderImpl();
	}
	
	default Class<? extends Portfolio> getType() {
		return Portfolio.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("aggregationParameters"), processor, AggregationParameters.class, getAggregationParameters());
		processRosetta(path.newSubPath("portfolioState"), processor, PortfolioState.class, getPortfolioState());
	}
	
	
	interface PortfolioBuilder extends Portfolio, RosettaModelObjectBuilder {
		AggregationParameters.AggregationParametersBuilder getOrCreateAggregationParameters();
		AggregationParameters.AggregationParametersBuilder getAggregationParameters();
		PortfolioState.PortfolioStateBuilder getOrCreatePortfolioState();
		PortfolioState.PortfolioStateBuilder getPortfolioState();
		Portfolio.PortfolioBuilder setAggregationParameters(AggregationParameters aggregationParameters);
		Portfolio.PortfolioBuilder setPortfolioState(PortfolioState portfolioState);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("aggregationParameters"), processor, AggregationParameters.AggregationParametersBuilder.class, getAggregationParameters());
			processRosetta(path.newSubPath("portfolioState"), processor, PortfolioState.PortfolioStateBuilder.class, getPortfolioState());
		}
		
	}
	
	//Portfolio.PortfolioImpl
	class PortfolioImpl implements Portfolio {
		private final AggregationParameters aggregationParameters;
		private final PortfolioState portfolioState;
		
		protected PortfolioImpl(Portfolio.PortfolioBuilder builder) {
			this.aggregationParameters = ofNullable(builder.getAggregationParameters()).map(f->f.build()).orElse(null);
			this.portfolioState = ofNullable(builder.getPortfolioState()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AggregationParameters getAggregationParameters() {
			return aggregationParameters;
		}
		
		@Override
		public PortfolioState getPortfolioState() {
			return portfolioState;
		}
		
		@Override
		public Portfolio build() {
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder toBuilder() {
			Portfolio.PortfolioBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Portfolio.PortfolioBuilder builder) {
			ofNullable(getAggregationParameters()).ifPresent(builder::setAggregationParameters);
			ofNullable(getPortfolioState()).ifPresent(builder::setPortfolioState);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Portfolio _that = getType().cast(o);
		
			if (!Objects.equals(aggregationParameters, _that.getAggregationParameters())) return false;
			if (!Objects.equals(portfolioState, _that.getPortfolioState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (aggregationParameters != null ? aggregationParameters.hashCode() : 0);
			_result = 31 * _result + (portfolioState != null ? portfolioState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Portfolio {" +
				"aggregationParameters=" + this.aggregationParameters + ", " +
				"portfolioState=" + this.portfolioState +
			'}';
		}
	}
	
	//Portfolio.PortfolioBuilderImpl
	class PortfolioBuilderImpl implements Portfolio.PortfolioBuilder {
	
		protected AggregationParameters.AggregationParametersBuilder aggregationParameters;
		protected PortfolioState.PortfolioStateBuilder portfolioState;
	
		public PortfolioBuilderImpl() {
		}
	
		@Override
		public AggregationParameters.AggregationParametersBuilder getAggregationParameters() {
			return aggregationParameters;
		}
		
		@Override
		public AggregationParameters.AggregationParametersBuilder getOrCreateAggregationParameters() {
			AggregationParameters.AggregationParametersBuilder result;
			if (aggregationParameters!=null) {
				result = aggregationParameters;
			}
			else {
				result = aggregationParameters = AggregationParameters.builder();
			}
			
			return result;
		}
		
		@Override
		public PortfolioState.PortfolioStateBuilder getPortfolioState() {
			return portfolioState;
		}
		
		@Override
		public PortfolioState.PortfolioStateBuilder getOrCreatePortfolioState() {
			PortfolioState.PortfolioStateBuilder result;
			if (portfolioState!=null) {
				result = portfolioState;
			}
			else {
				result = portfolioState = PortfolioState.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Portfolio.PortfolioBuilder setAggregationParameters(AggregationParameters aggregationParameters) {
			this.aggregationParameters = aggregationParameters==null?null:aggregationParameters.toBuilder();
			return this;
		}
		@Override
		public Portfolio.PortfolioBuilder setPortfolioState(PortfolioState portfolioState) {
			this.portfolioState = portfolioState==null?null:portfolioState.toBuilder();
			return this;
		}
		
		@Override
		public Portfolio build() {
			return new Portfolio.PortfolioImpl(this);
		}
		
		@Override
		public Portfolio.PortfolioBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Portfolio.PortfolioBuilder prune() {
			if (aggregationParameters!=null && !aggregationParameters.prune().hasData()) aggregationParameters = null;
			if (portfolioState!=null && !portfolioState.prune().hasData()) portfolioState = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAggregationParameters()!=null && getAggregationParameters().hasData()) return true;
			if (getPortfolioState()!=null && getPortfolioState().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Portfolio.PortfolioBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Portfolio.PortfolioBuilder o = (Portfolio.PortfolioBuilder) other;
			
			merger.mergeRosetta(getAggregationParameters(), o.getAggregationParameters(), this::setAggregationParameters);
			merger.mergeRosetta(getPortfolioState(), o.getPortfolioState(), this::setPortfolioState);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Portfolio _that = getType().cast(o);
		
			if (!Objects.equals(aggregationParameters, _that.getAggregationParameters())) return false;
			if (!Objects.equals(portfolioState, _that.getPortfolioState())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (aggregationParameters != null ? aggregationParameters.hashCode() : 0);
			_result = 31 * _result + (portfolioState != null ? portfolioState.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioBuilder {" +
				"aggregationParameters=" + this.aggregationParameters + ", " +
				"portfolioState=" + this.portfolioState +
			'}';
		}
	}
}
