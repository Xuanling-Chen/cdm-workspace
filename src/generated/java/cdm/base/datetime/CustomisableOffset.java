package cdm.base.datetime;

import cdm.base.datetime.meta.CustomisableOffsetMeta;
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
 * A class to specify an offset either as a normalized [multiplier, period, dayType] or as a custom provision of type string.
 * @version ${project.version}
 */
@RosettaClass

public interface CustomisableOffset extends RosettaModelObject {
	CustomisableOffset build();
	CustomisableOffset.CustomisableOffsetBuilder toBuilder();
	
	/**
	 */
	String getCustomProvision();
	/**
	 */
	Offset getOffset();
	final static CustomisableOffsetMeta metaData = new CustomisableOffsetMeta();
	
	@Override
	default RosettaMetaData<? extends CustomisableOffset> metaData() {
		return metaData;
	} 
			
	static CustomisableOffset.CustomisableOffsetBuilder builder() {
		return new CustomisableOffset.CustomisableOffsetBuilderImpl();
	}
	
	default Class<? extends CustomisableOffset> getType() {
		return CustomisableOffset.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
		
		processRosetta(path.newSubPath("offset"), processor, Offset.class, getOffset());
	}
	
	
	interface CustomisableOffsetBuilder extends CustomisableOffset, RosettaModelObjectBuilder {
		Offset.OffsetBuilder getOrCreateOffset();
		Offset.OffsetBuilder getOffset();
		CustomisableOffset.CustomisableOffsetBuilder setCustomProvision(String customProvision);
		CustomisableOffset.CustomisableOffsetBuilder setOffset(Offset offset);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customProvision"), String.class, getCustomProvision(), this);
			
			processRosetta(path.newSubPath("offset"), processor, Offset.OffsetBuilder.class, getOffset());
		}
		
	}
	
	//CustomisableOffset.CustomisableOffsetImpl
	class CustomisableOffsetImpl implements CustomisableOffset {
		private final String customProvision;
		private final Offset offset;
		
		protected CustomisableOffsetImpl(CustomisableOffset.CustomisableOffsetBuilder builder) {
			this.customProvision = builder.getCustomProvision();
			this.offset = ofNullable(builder.getOffset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getCustomProvision() {
			return customProvision;
		}
		
		@Override
		public Offset getOffset() {
			return offset;
		}
		
		@Override
		public CustomisableOffset build() {
			return this;
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder toBuilder() {
			CustomisableOffset.CustomisableOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustomisableOffset.CustomisableOffsetBuilder builder) {
			ofNullable(getCustomProvision()).ifPresent(builder::setCustomProvision);
			ofNullable(getOffset()).ifPresent(builder::setOffset);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustomisableOffset _that = getType().cast(o);
		
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustomisableOffset {" +
				"customProvision=" + this.customProvision + ", " +
				"offset=" + this.offset +
			'}';
		}
	}
	
	//CustomisableOffset.CustomisableOffsetBuilderImpl
	class CustomisableOffsetBuilderImpl implements CustomisableOffset.CustomisableOffsetBuilder {
	
		protected String customProvision;
		protected Offset.OffsetBuilder offset;
	
		public CustomisableOffsetBuilderImpl() {
		}
	
		@Override
		public String getCustomProvision() {
			return customProvision;
		}
		
		@Override
		public Offset.OffsetBuilder getOffset() {
			return offset;
		}
		
		@Override
		public Offset.OffsetBuilder getOrCreateOffset() {
			Offset.OffsetBuilder result;
			if (offset!=null) {
				result = offset;
			}
			else {
				result = offset = Offset.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder setCustomProvision(String customProvision) {
			this.customProvision = customProvision==null?null:customProvision;
			return this;
		}
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder setOffset(Offset offset) {
			this.offset = offset==null?null:offset.toBuilder();
			return this;
		}
		
		@Override
		public CustomisableOffset build() {
			return new CustomisableOffset.CustomisableOffsetImpl(this);
		}
		
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder prune() {
			if (offset!=null && !offset.prune().hasData()) offset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCustomProvision()!=null) return true;
			if (getOffset()!=null && getOffset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustomisableOffset.CustomisableOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustomisableOffset.CustomisableOffsetBuilder o = (CustomisableOffset.CustomisableOffsetBuilder) other;
			
			merger.mergeRosetta(getOffset(), o.getOffset(), this::setOffset);
			
			merger.mergeBasic(getCustomProvision(), o.getCustomProvision(), this::setCustomProvision);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustomisableOffset _that = getType().cast(o);
		
			if (!Objects.equals(customProvision, _that.getCustomProvision())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (customProvision != null ? customProvision.hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustomisableOffsetBuilder {" +
				"customProvision=" + this.customProvision + ", " +
				"offset=" + this.offset +
			'}';
		}
	}
}
