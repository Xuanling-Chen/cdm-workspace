package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.SensitivityMethodologiesMeta;
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
 * A class to specificy methodologies to compute sensitivities specific to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface SensitivityMethodologies extends RosettaModelObject {
	SensitivityMethodologies build();
	SensitivityMethodologies.SensitivityMethodologiesBuilder toBuilder();
	
	/**
	 * The methodology to compute sensitivities to commodity indices for the purpose of Initial Margin agreements.
	 */
	SensitivityMethodology getSensitivityToCommodity();
	/**
	 * The methodology to compute sensitivities to equity indices, funds and ETFs for the purpose of Initial Margin agreements.
	 */
	SensitivityMethodology getSensitivityToEquity();
	final static SensitivityMethodologiesMeta metaData = new SensitivityMethodologiesMeta();
	
	@Override
	default RosettaMetaData<? extends SensitivityMethodologies> metaData() {
		return metaData;
	} 
			
	static SensitivityMethodologies.SensitivityMethodologiesBuilder builder() {
		return new SensitivityMethodologies.SensitivityMethodologiesBuilderImpl();
	}
	
	default Class<? extends SensitivityMethodologies> getType() {
		return SensitivityMethodologies.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("sensitivityToCommodity"), processor, SensitivityMethodology.class, getSensitivityToCommodity());
		processRosetta(path.newSubPath("sensitivityToEquity"), processor, SensitivityMethodology.class, getSensitivityToEquity());
	}
	
	
	interface SensitivityMethodologiesBuilder extends SensitivityMethodologies, RosettaModelObjectBuilder {
		SensitivityMethodology.SensitivityMethodologyBuilder getOrCreateSensitivityToCommodity();
		SensitivityMethodology.SensitivityMethodologyBuilder getSensitivityToCommodity();
		SensitivityMethodology.SensitivityMethodologyBuilder getOrCreateSensitivityToEquity();
		SensitivityMethodology.SensitivityMethodologyBuilder getSensitivityToEquity();
		SensitivityMethodologies.SensitivityMethodologiesBuilder setSensitivityToCommodity(SensitivityMethodology sensitivityToCommodity);
		SensitivityMethodologies.SensitivityMethodologiesBuilder setSensitivityToEquity(SensitivityMethodology sensitivityToEquity);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("sensitivityToCommodity"), processor, SensitivityMethodology.SensitivityMethodologyBuilder.class, getSensitivityToCommodity());
			processRosetta(path.newSubPath("sensitivityToEquity"), processor, SensitivityMethodology.SensitivityMethodologyBuilder.class, getSensitivityToEquity());
		}
		
	}
	
	//SensitivityMethodologies.SensitivityMethodologiesImpl
	class SensitivityMethodologiesImpl implements SensitivityMethodologies {
		private final SensitivityMethodology sensitivityToCommodity;
		private final SensitivityMethodology sensitivityToEquity;
		
		protected SensitivityMethodologiesImpl(SensitivityMethodologies.SensitivityMethodologiesBuilder builder) {
			this.sensitivityToCommodity = ofNullable(builder.getSensitivityToCommodity()).map(f->f.build()).orElse(null);
			this.sensitivityToEquity = ofNullable(builder.getSensitivityToEquity()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public SensitivityMethodology getSensitivityToCommodity() {
			return sensitivityToCommodity;
		}
		
		@Override
		public SensitivityMethodology getSensitivityToEquity() {
			return sensitivityToEquity;
		}
		
		@Override
		public SensitivityMethodologies build() {
			return this;
		}
		
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder toBuilder() {
			SensitivityMethodologies.SensitivityMethodologiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivityMethodologies.SensitivityMethodologiesBuilder builder) {
			ofNullable(getSensitivityToCommodity()).ifPresent(builder::setSensitivityToCommodity);
			ofNullable(getSensitivityToEquity()).ifPresent(builder::setSensitivityToEquity);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityMethodologies _that = getType().cast(o);
		
			if (!Objects.equals(sensitivityToCommodity, _that.getSensitivityToCommodity())) return false;
			if (!Objects.equals(sensitivityToEquity, _that.getSensitivityToEquity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sensitivityToCommodity != null ? sensitivityToCommodity.hashCode() : 0);
			_result = 31 * _result + (sensitivityToEquity != null ? sensitivityToEquity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityMethodologies {" +
				"sensitivityToCommodity=" + this.sensitivityToCommodity + ", " +
				"sensitivityToEquity=" + this.sensitivityToEquity +
			'}';
		}
	}
	
	//SensitivityMethodologies.SensitivityMethodologiesBuilderImpl
	class SensitivityMethodologiesBuilderImpl implements SensitivityMethodologies.SensitivityMethodologiesBuilder {
	
		protected SensitivityMethodology.SensitivityMethodologyBuilder sensitivityToCommodity;
		protected SensitivityMethodology.SensitivityMethodologyBuilder sensitivityToEquity;
	
		public SensitivityMethodologiesBuilderImpl() {
		}
	
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder getSensitivityToCommodity() {
			return sensitivityToCommodity;
		}
		
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder getOrCreateSensitivityToCommodity() {
			SensitivityMethodology.SensitivityMethodologyBuilder result;
			if (sensitivityToCommodity!=null) {
				result = sensitivityToCommodity;
			}
			else {
				result = sensitivityToCommodity = SensitivityMethodology.builder();
			}
			
			return result;
		}
		
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder getSensitivityToEquity() {
			return sensitivityToEquity;
		}
		
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder getOrCreateSensitivityToEquity() {
			SensitivityMethodology.SensitivityMethodologyBuilder result;
			if (sensitivityToEquity!=null) {
				result = sensitivityToEquity;
			}
			else {
				result = sensitivityToEquity = SensitivityMethodology.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder setSensitivityToCommodity(SensitivityMethodology sensitivityToCommodity) {
			this.sensitivityToCommodity = sensitivityToCommodity==null?null:sensitivityToCommodity.toBuilder();
			return this;
		}
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder setSensitivityToEquity(SensitivityMethodology sensitivityToEquity) {
			this.sensitivityToEquity = sensitivityToEquity==null?null:sensitivityToEquity.toBuilder();
			return this;
		}
		
		@Override
		public SensitivityMethodologies build() {
			return new SensitivityMethodologies.SensitivityMethodologiesImpl(this);
		}
		
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder prune() {
			if (sensitivityToCommodity!=null && !sensitivityToCommodity.prune().hasData()) sensitivityToCommodity = null;
			if (sensitivityToEquity!=null && !sensitivityToEquity.prune().hasData()) sensitivityToEquity = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSensitivityToCommodity()!=null && getSensitivityToCommodity().hasData()) return true;
			if (getSensitivityToEquity()!=null && getSensitivityToEquity().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityMethodologies.SensitivityMethodologiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivityMethodologies.SensitivityMethodologiesBuilder o = (SensitivityMethodologies.SensitivityMethodologiesBuilder) other;
			
			merger.mergeRosetta(getSensitivityToCommodity(), o.getSensitivityToCommodity(), this::setSensitivityToCommodity);
			merger.mergeRosetta(getSensitivityToEquity(), o.getSensitivityToEquity(), this::setSensitivityToEquity);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityMethodologies _that = getType().cast(o);
		
			if (!Objects.equals(sensitivityToCommodity, _that.getSensitivityToCommodity())) return false;
			if (!Objects.equals(sensitivityToEquity, _that.getSensitivityToEquity())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (sensitivityToCommodity != null ? sensitivityToCommodity.hashCode() : 0);
			_result = 31 * _result + (sensitivityToEquity != null ? sensitivityToEquity.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityMethodologiesBuilder {" +
				"sensitivityToCommodity=" + this.sensitivityToCommodity + ", " +
				"sensitivityToEquity=" + this.sensitivityToEquity +
			'}';
		}
	}
}
