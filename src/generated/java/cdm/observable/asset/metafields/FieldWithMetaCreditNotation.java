package cdm.observable.asset.metafields;

import cdm.observable.asset.CreditNotation;
import cdm.observable.asset.metafields.FieldWithMetaCreditNotation;
import cdm.observable.asset.metafields.FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder;
import cdm.observable.asset.metafields.FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilderImpl;
import cdm.observable.asset.metafields.FieldWithMetaCreditNotation.FieldWithMetaCreditNotationImpl;
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

public interface FieldWithMetaCreditNotation extends RosettaModelObject, FieldWithMeta<CreditNotation>, GlobalKey {
	FieldWithMetaCreditNotation build();
	FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	CreditNotation getValue();
	final static FieldWithMetaCreditNotationMeta metaData = new FieldWithMetaCreditNotationMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaCreditNotation> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder builder() {
		return new FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaCreditNotation> getType() {
		return FieldWithMetaCreditNotation.class;
	}
	
		default Class<CreditNotation> getValueType() {
			return CreditNotation.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("value"), processor, CreditNotation.class, getValue());
	}
	
	
	interface FieldWithMetaCreditNotationBuilder extends FieldWithMetaCreditNotation, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<CreditNotation> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		CreditNotation.CreditNotationBuilder getOrCreateValue();
		CreditNotation.CreditNotationBuilder getValue();
		FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder setMeta(MetaFields meta);
		FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder setValue(CreditNotation value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("value"), processor, CreditNotation.CreditNotationBuilder.class, getValue());
		}
		
	}
	
	//FieldWithMetaCreditNotation.FieldWithMetaCreditNotationImpl
	class FieldWithMetaCreditNotationImpl implements FieldWithMetaCreditNotation {
		private final MetaFields meta;
		private final CreditNotation value;
		
		protected FieldWithMetaCreditNotationImpl(FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public CreditNotation getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaCreditNotation build() {
			return this;
		}
		
		@Override
		public FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder toBuilder() {
			FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCreditNotation _that = getType().cast(o);
		
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
			return "FieldWithMetaCreditNotation {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilderImpl
	class FieldWithMetaCreditNotationBuilderImpl implements FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected CreditNotation.CreditNotationBuilder value;
	
		public FieldWithMetaCreditNotationBuilderImpl() {
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
		public CreditNotation.CreditNotationBuilder getValue() {
			return value;
		}
		
		@Override
		public CreditNotation.CreditNotationBuilder getOrCreateValue() {
			CreditNotation.CreditNotationBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = CreditNotation.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder setValue(CreditNotation value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaCreditNotation build() {
			return new FieldWithMetaCreditNotation.FieldWithMetaCreditNotationImpl(this);
		}
		
		@Override
		public FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder prune() {
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
		public FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder o = (FieldWithMetaCreditNotation.FieldWithMetaCreditNotationBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCreditNotation _that = getType().cast(o);
		
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
			return "FieldWithMetaCreditNotationBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaCreditNotationMeta extends BasicRosettaMetaData<FieldWithMetaCreditNotation>{

}
