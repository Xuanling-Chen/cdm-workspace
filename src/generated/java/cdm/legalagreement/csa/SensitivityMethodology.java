package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.SensitivityMethodologyMeta;
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
 * A class to specify the methodology according to which sensitivities to (i) equity indices, funds and ETFs, and (ii) commodity indices are computed. This specification is done either through a normalized election as part of the specifiedMethodology, or through a custom election via the customMethodology attribute. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (gg)(2).
 * @version ${project.version}
 */
@RosettaClass

public interface SensitivityMethodology extends RosettaModelObject {
	SensitivityMethodology build();
	SensitivityMethodology.SensitivityMethodologyBuilder toBuilder();
	
	/**
	 * The methodology according to which sensitivities will be computed, when specified through a custom election.
	 */
	String getCustomMethodology();
	/**
	 * The methodology according to which sensitivities will be computed, when specified through a normalized election.
	 */
	SensitivitiesEnum getSpecifiedMethodology();
	final static SensitivityMethodologyMeta metaData = new SensitivityMethodologyMeta();
	
	@Override
	default RosettaMetaData<? extends SensitivityMethodology> metaData() {
		return metaData;
	} 
			
	static SensitivityMethodology.SensitivityMethodologyBuilder builder() {
		return new SensitivityMethodology.SensitivityMethodologyBuilderImpl();
	}
	
	default Class<? extends SensitivityMethodology> getType() {
		return SensitivityMethodology.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customMethodology"), String.class, getCustomMethodology(), this);
		processor.processBasic(path.newSubPath("specifiedMethodology"), SensitivitiesEnum.class, getSpecifiedMethodology(), this);
		
	}
	
	
	interface SensitivityMethodologyBuilder extends SensitivityMethodology, RosettaModelObjectBuilder {
		SensitivityMethodology.SensitivityMethodologyBuilder setCustomMethodology(String customMethodology);
		SensitivityMethodology.SensitivityMethodologyBuilder setSpecifiedMethodology(SensitivitiesEnum specifiedMethodology);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customMethodology"), String.class, getCustomMethodology(), this);
			processor.processBasic(path.newSubPath("specifiedMethodology"), SensitivitiesEnum.class, getSpecifiedMethodology(), this);
			
		}
		
	}
	
	//SensitivityMethodology.SensitivityMethodologyImpl
	class SensitivityMethodologyImpl implements SensitivityMethodology {
		private final String customMethodology;
		private final SensitivitiesEnum specifiedMethodology;
		
		protected SensitivityMethodologyImpl(SensitivityMethodology.SensitivityMethodologyBuilder builder) {
			this.customMethodology = builder.getCustomMethodology();
			this.specifiedMethodology = builder.getSpecifiedMethodology();
		}
		
		@Override
		public String getCustomMethodology() {
			return customMethodology;
		}
		
		@Override
		public SensitivitiesEnum getSpecifiedMethodology() {
			return specifiedMethodology;
		}
		
		@Override
		public SensitivityMethodology build() {
			return this;
		}
		
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder toBuilder() {
			SensitivityMethodology.SensitivityMethodologyBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivityMethodology.SensitivityMethodologyBuilder builder) {
			ofNullable(getCustomMethodology()).ifPresent(builder::setCustomMethodology);
			ofNullable(getSpecifiedMethodology()).ifPresent(builder::setSpecifiedMethodology);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityMethodology _that = getType().cast(o);
		
			if (!Objects.equals(customMethodology, _that.getCustomMethodology())) return false;
			if (!Objects.equals(specifiedMethodology, _that.getSpecifiedMethodology())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customMethodology != null ? customMethodology.hashCode() : 0);
			_result = 31 * _result + (specifiedMethodology != null ? specifiedMethodology.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityMethodology {" +
				"customMethodology=" + this.customMethodology + ", " +
				"specifiedMethodology=" + this.specifiedMethodology +
			'}';
		}
	}
	
	//SensitivityMethodology.SensitivityMethodologyBuilderImpl
	class SensitivityMethodologyBuilderImpl implements SensitivityMethodology.SensitivityMethodologyBuilder {
	
		protected String customMethodology;
		protected SensitivitiesEnum specifiedMethodology;
	
		public SensitivityMethodologyBuilderImpl() {
		}
	
		@Override
		public String getCustomMethodology() {
			return customMethodology;
		}
		
		@Override
		public SensitivitiesEnum getSpecifiedMethodology() {
			return specifiedMethodology;
		}
		
	
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder setCustomMethodology(String customMethodology) {
			this.customMethodology = customMethodology==null?null:customMethodology;
			return this;
		}
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder setSpecifiedMethodology(SensitivitiesEnum specifiedMethodology) {
			this.specifiedMethodology = specifiedMethodology==null?null:specifiedMethodology;
			return this;
		}
		
		@Override
		public SensitivityMethodology build() {
			return new SensitivityMethodology.SensitivityMethodologyImpl(this);
		}
		
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomMethodology()!=null) return true;
			if (getSpecifiedMethodology()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivityMethodology.SensitivityMethodologyBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivityMethodology.SensitivityMethodologyBuilder o = (SensitivityMethodology.SensitivityMethodologyBuilder) other;
			
			
			merger.mergeBasic(getCustomMethodology(), o.getCustomMethodology(), this::setCustomMethodology);
			merger.mergeBasic(getSpecifiedMethodology(), o.getSpecifiedMethodology(), this::setSpecifiedMethodology);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivityMethodology _that = getType().cast(o);
		
			if (!Objects.equals(customMethodology, _that.getCustomMethodology())) return false;
			if (!Objects.equals(specifiedMethodology, _that.getSpecifiedMethodology())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customMethodology != null ? customMethodology.hashCode() : 0);
			_result = 31 * _result + (specifiedMethodology != null ? specifiedMethodology.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivityMethodologyBuilder {" +
				"customMethodology=" + this.customMethodology + ", " +
				"specifiedMethodology=" + this.specifiedMethodology +
			'}';
		}
	}
}
