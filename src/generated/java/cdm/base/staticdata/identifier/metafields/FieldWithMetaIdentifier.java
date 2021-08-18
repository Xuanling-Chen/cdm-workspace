package cdm.base.staticdata.identifier.metafields;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilderImpl;
import cdm.base.staticdata.identifier.metafields.FieldWithMetaIdentifier.FieldWithMetaIdentifierImpl;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.FieldWithMeta;
import com.rosetta.model.lib.meta.FieldWithMeta.FieldWithMetaBuilder;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import java.util.Objects;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface FieldWithMetaIdentifier extends RosettaModelObject, FieldWithMeta<Identifier>, GlobalKey {
	FieldWithMetaIdentifier build();
	FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	Identifier getValue();
	final static FieldWithMetaIdentifierMeta metaData = new FieldWithMetaIdentifierMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaIdentifier> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder builder() {
		return new FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaIdentifier> getType() {
		return FieldWithMetaIdentifier.class;
	}
	
		default Class<Identifier> getValueType() {
			return Identifier.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("value"), processor, Identifier.class, getValue());
	}
	
	
	interface FieldWithMetaIdentifierBuilder extends FieldWithMetaIdentifier, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<Identifier> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Identifier.IdentifierBuilder getOrCreateValue();
		Identifier.IdentifierBuilder getValue();
		FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder setMeta(MetaFields meta);
		FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder setValue(Identifier value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("value"), processor, Identifier.IdentifierBuilder.class, getValue());
		}
		
	}
	
	//FieldWithMetaIdentifier.FieldWithMetaIdentifierImpl
	class FieldWithMetaIdentifierImpl implements FieldWithMetaIdentifier {
		private final MetaFields meta;
		private final Identifier value;
		
		protected FieldWithMetaIdentifierImpl(FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Identifier getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaIdentifier build() {
			return this;
		}
		
		@Override
		public FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder toBuilder() {
			FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaIdentifier {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilderImpl
	class FieldWithMetaIdentifierBuilderImpl implements FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected Identifier.IdentifierBuilder value;
	
		public FieldWithMetaIdentifierBuilderImpl() {
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
		public Identifier.IdentifierBuilder getValue() {
			return value;
		}
		
		@Override
		public Identifier.IdentifierBuilder getOrCreateValue() {
			Identifier.IdentifierBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = Identifier.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder setValue(Identifier value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaIdentifier build() {
			return new FieldWithMetaIdentifier.FieldWithMetaIdentifierImpl(this);
		}
		
		@Override
		public FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder prune() {
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (value!=null && !value.prune().hasData()) value = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null && getValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder o = (FieldWithMetaIdentifier.FieldWithMetaIdentifierBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FieldWithMetaIdentifierBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaIdentifierMeta extends BasicRosettaMetaData<FieldWithMetaIdentifier>{

}
