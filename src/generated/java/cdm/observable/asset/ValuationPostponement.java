package cdm.observable.asset;

import cdm.observable.asset.meta.ValuationPostponementMeta;
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
 * Specifies how long to wait to get a quote from a settlement rate option upon a price source disruption.
 * @version ${project.version}
 */
@RosettaClass

public interface ValuationPostponement extends RosettaModelObject {
	ValuationPostponement build();
	ValuationPostponement.ValuationPostponementBuilder toBuilder();
	
	/**
	 * The maximum number of days to wait for a quote from the disrupted settlement rate option before proceeding to the next method.
	 */
	Integer getMaximumDaysOfPostponement();
	final static ValuationPostponementMeta metaData = new ValuationPostponementMeta();
	
	@Override
	default RosettaMetaData<? extends ValuationPostponement> metaData() {
		return metaData;
	} 
			
	static ValuationPostponement.ValuationPostponementBuilder builder() {
		return new ValuationPostponement.ValuationPostponementBuilderImpl();
	}
	
	default Class<? extends ValuationPostponement> getType() {
		return ValuationPostponement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("maximumDaysOfPostponement"), Integer.class, getMaximumDaysOfPostponement(), this);
		
	}
	
	
	interface ValuationPostponementBuilder extends ValuationPostponement, RosettaModelObjectBuilder {
		ValuationPostponement.ValuationPostponementBuilder setMaximumDaysOfPostponement(Integer maximumDaysOfPostponement);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("maximumDaysOfPostponement"), Integer.class, getMaximumDaysOfPostponement(), this);
			
		}
		
	}
	
	//ValuationPostponement.ValuationPostponementImpl
	class ValuationPostponementImpl implements ValuationPostponement {
		private final Integer maximumDaysOfPostponement;
		
		protected ValuationPostponementImpl(ValuationPostponement.ValuationPostponementBuilder builder) {
			this.maximumDaysOfPostponement = builder.getMaximumDaysOfPostponement();
		}
		
		@Override
		public Integer getMaximumDaysOfPostponement() {
			return maximumDaysOfPostponement;
		}
		
		@Override
		public ValuationPostponement build() {
			return this;
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder toBuilder() {
			ValuationPostponement.ValuationPostponementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationPostponement.ValuationPostponementBuilder builder) {
			ofNullable(getMaximumDaysOfPostponement()).ifPresent(builder::setMaximumDaysOfPostponement);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationPostponement _that = getType().cast(o);
		
			if (!Objects.equals(maximumDaysOfPostponement, _that.getMaximumDaysOfPostponement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (maximumDaysOfPostponement != null ? maximumDaysOfPostponement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationPostponement {" +
				"maximumDaysOfPostponement=" + this.maximumDaysOfPostponement +
			'}';
		}
	}
	
	//ValuationPostponement.ValuationPostponementBuilderImpl
	class ValuationPostponementBuilderImpl implements ValuationPostponement.ValuationPostponementBuilder {
	
		protected Integer maximumDaysOfPostponement;
	
		public ValuationPostponementBuilderImpl() {
		}
	
		@Override
		public Integer getMaximumDaysOfPostponement() {
			return maximumDaysOfPostponement;
		}
		
	
		@Override
		public ValuationPostponement.ValuationPostponementBuilder setMaximumDaysOfPostponement(Integer maximumDaysOfPostponement) {
			this.maximumDaysOfPostponement = maximumDaysOfPostponement==null?null:maximumDaysOfPostponement;
			return this;
		}
		
		@Override
		public ValuationPostponement build() {
			return new ValuationPostponement.ValuationPostponementImpl(this);
		}
		
		@Override
		public ValuationPostponement.ValuationPostponementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationPostponement.ValuationPostponementBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMaximumDaysOfPostponement()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationPostponement.ValuationPostponementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ValuationPostponement.ValuationPostponementBuilder o = (ValuationPostponement.ValuationPostponementBuilder) other;
			
			
			merger.mergeBasic(getMaximumDaysOfPostponement(), o.getMaximumDaysOfPostponement(), this::setMaximumDaysOfPostponement);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ValuationPostponement _that = getType().cast(o);
		
			if (!Objects.equals(maximumDaysOfPostponement, _that.getMaximumDaysOfPostponement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (maximumDaysOfPostponement != null ? maximumDaysOfPostponement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationPostponementBuilder {" +
				"maximumDaysOfPostponement=" + this.maximumDaysOfPostponement +
			'}';
		}
	}
}
