package cdm.observable.asset.metafields;

import cdm.observable.asset.QuotedCurrencyPair;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilderImpl;
import cdm.observable.asset.metafields.FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairImpl;
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

public interface FieldWithMetaQuotedCurrencyPair extends RosettaModelObject, FieldWithMeta<QuotedCurrencyPair>, GlobalKey {
	FieldWithMetaQuotedCurrencyPair build();
	FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	QuotedCurrencyPair getValue();
	final static FieldWithMetaQuotedCurrencyPairMeta metaData = new FieldWithMetaQuotedCurrencyPairMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaQuotedCurrencyPair> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder builder() {
		return new FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaQuotedCurrencyPair> getType() {
		return FieldWithMetaQuotedCurrencyPair.class;
	}
	
		default Class<QuotedCurrencyPair> getValueType() {
			return QuotedCurrencyPair.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("value"), processor, QuotedCurrencyPair.class, getValue());
	}
	
	
	interface FieldWithMetaQuotedCurrencyPairBuilder extends FieldWithMetaQuotedCurrencyPair, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<QuotedCurrencyPair> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateValue();
		QuotedCurrencyPair.QuotedCurrencyPairBuilder getValue();
		FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder setMeta(MetaFields meta);
		FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder setValue(QuotedCurrencyPair value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("value"), processor, QuotedCurrencyPair.QuotedCurrencyPairBuilder.class, getValue());
		}
		
	}
	
	//FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairImpl
	class FieldWithMetaQuotedCurrencyPairImpl implements FieldWithMetaQuotedCurrencyPair {
		private final MetaFields meta;
		private final QuotedCurrencyPair value;
		
		protected FieldWithMetaQuotedCurrencyPairImpl(FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public QuotedCurrencyPair getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaQuotedCurrencyPair build() {
			return this;
		}
		
		@Override
		public FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder toBuilder() {
			FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaQuotedCurrencyPair _that = getType().cast(o);
		
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
			return "FieldWithMetaQuotedCurrencyPair {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilderImpl
	class FieldWithMetaQuotedCurrencyPairBuilderImpl implements FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected QuotedCurrencyPair.QuotedCurrencyPairBuilder value;
	
		public FieldWithMetaQuotedCurrencyPairBuilderImpl() {
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
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getValue() {
			return value;
		}
		
		@Override
		public QuotedCurrencyPair.QuotedCurrencyPairBuilder getOrCreateValue() {
			QuotedCurrencyPair.QuotedCurrencyPairBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = QuotedCurrencyPair.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder setValue(QuotedCurrencyPair value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaQuotedCurrencyPair build() {
			return new FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairImpl(this);
		}
		
		@Override
		public FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder prune() {
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
		public FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder o = (FieldWithMetaQuotedCurrencyPair.FieldWithMetaQuotedCurrencyPairBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaQuotedCurrencyPair _that = getType().cast(o);
		
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
			return "FieldWithMetaQuotedCurrencyPairBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaQuotedCurrencyPairMeta extends BasicRosettaMetaData<FieldWithMetaQuotedCurrencyPair>{

}
