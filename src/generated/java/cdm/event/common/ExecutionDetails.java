package cdm.event.common;

import cdm.base.staticdata.party.LegalEntity;
import cdm.event.common.meta.ExecutionDetailsMeta;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines specific attributes that relate to trade executions.
 * @version ${project.version}
 */
@RosettaClass

public interface ExecutionDetails extends RosettaModelObject, GlobalKey {
	ExecutionDetails build();
	ExecutionDetails.ExecutionDetailsBuilder toBuilder();
	
	/**
	 * Identifies the type of execution, e.g. via voice, electronically...
	 */
	ExecutionTypeEnum getExecutionType();
	/**
	 * Represents the venue on which a trade was executed.
	 */
	LegalEntity getExecutionVenue();
	/**
	 */
	MetaFields getMeta();
	final static ExecutionDetailsMeta metaData = new ExecutionDetailsMeta();
	
	@Override
	default RosettaMetaData<? extends ExecutionDetails> metaData() {
		return metaData;
	} 
			
	static ExecutionDetails.ExecutionDetailsBuilder builder() {
		return new ExecutionDetails.ExecutionDetailsBuilderImpl();
	}
	
	default Class<? extends ExecutionDetails> getType() {
		return ExecutionDetails.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("executionType"), ExecutionTypeEnum.class, getExecutionType(), this);
		
		processRosetta(path.newSubPath("executionVenue"), processor, LegalEntity.class, getExecutionVenue());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
	}
	
	
	interface ExecutionDetailsBuilder extends ExecutionDetails, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateExecutionVenue();
		LegalEntity.LegalEntityBuilder getExecutionVenue();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ExecutionDetails.ExecutionDetailsBuilder setExecutionType(ExecutionTypeEnum executionType);
		ExecutionDetails.ExecutionDetailsBuilder setExecutionVenue(LegalEntity executionVenue);
		ExecutionDetails.ExecutionDetailsBuilder setMeta(MetaFields meta);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("executionType"), ExecutionTypeEnum.class, getExecutionType(), this);
			
			processRosetta(path.newSubPath("executionVenue"), processor, LegalEntity.LegalEntityBuilder.class, getExecutionVenue());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
		}
		
	}
	
	//ExecutionDetails.ExecutionDetailsImpl
	class ExecutionDetailsImpl implements ExecutionDetails {
		private final ExecutionTypeEnum executionType;
		private final LegalEntity executionVenue;
		private final MetaFields meta;
		
		protected ExecutionDetailsImpl(ExecutionDetails.ExecutionDetailsBuilder builder) {
			this.executionType = builder.getExecutionType();
			this.executionVenue = ofNullable(builder.getExecutionVenue()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public ExecutionTypeEnum getExecutionType() {
			return executionType;
		}
		
		@Override
		public LegalEntity getExecutionVenue() {
			return executionVenue;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public ExecutionDetails build() {
			return this;
		}
		
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder toBuilder() {
			ExecutionDetails.ExecutionDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ExecutionDetails.ExecutionDetailsBuilder builder) {
			ofNullable(getExecutionType()).ifPresent(builder::setExecutionType);
			ofNullable(getExecutionVenue()).ifPresent(builder::setExecutionVenue);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionDetails _that = getType().cast(o);
		
			if (!Objects.equals(executionType, _that.getExecutionType())) return false;
			if (!Objects.equals(executionVenue, _that.getExecutionVenue())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionType != null ? executionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (executionVenue != null ? executionVenue.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionDetails {" +
				"executionType=" + this.executionType + ", " +
				"executionVenue=" + this.executionVenue + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
	
	//ExecutionDetails.ExecutionDetailsBuilderImpl
	class ExecutionDetailsBuilderImpl implements ExecutionDetails.ExecutionDetailsBuilder, GlobalKeyBuilder {
	
		protected ExecutionTypeEnum executionType;
		protected LegalEntity.LegalEntityBuilder executionVenue;
		protected MetaFields.MetaFieldsBuilder meta;
	
		public ExecutionDetailsBuilderImpl() {
		}
	
		@Override
		public ExecutionTypeEnum getExecutionType() {
			return executionType;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getExecutionVenue() {
			return executionVenue;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateExecutionVenue() {
			LegalEntity.LegalEntityBuilder result;
			if (executionVenue!=null) {
				result = executionVenue;
			}
			else {
				result = executionVenue = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder setExecutionType(ExecutionTypeEnum executionType) {
			this.executionType = executionType==null?null:executionType;
			return this;
		}
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder setExecutionVenue(LegalEntity executionVenue) {
			this.executionVenue = executionVenue==null?null:executionVenue.toBuilder();
			return this;
		}
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		
		@Override
		public ExecutionDetails build() {
			return new ExecutionDetails.ExecutionDetailsImpl(this);
		}
		
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder prune() {
			if (executionVenue!=null && !executionVenue.prune().hasData()) executionVenue = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExecutionType()!=null) return true;
			if (getExecutionVenue()!=null && getExecutionVenue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ExecutionDetails.ExecutionDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ExecutionDetails.ExecutionDetailsBuilder o = (ExecutionDetails.ExecutionDetailsBuilder) other;
			
			merger.mergeRosetta(getExecutionVenue(), o.getExecutionVenue(), this::setExecutionVenue);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			
			merger.mergeBasic(getExecutionType(), o.getExecutionType(), this::setExecutionType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ExecutionDetails _that = getType().cast(o);
		
			if (!Objects.equals(executionType, _that.getExecutionType())) return false;
			if (!Objects.equals(executionVenue, _that.getExecutionVenue())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionType != null ? executionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (executionVenue != null ? executionVenue.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ExecutionDetailsBuilder {" +
				"executionType=" + this.executionType + ", " +
				"executionVenue=" + this.executionVenue + ", " +
				"meta=" + this.meta +
			'}';
		}
	}
}
