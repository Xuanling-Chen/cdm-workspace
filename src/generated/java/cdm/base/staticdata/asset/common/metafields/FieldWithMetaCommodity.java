package cdm.base.staticdata.asset.common.metafields;

import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity.FieldWithMetaCommodityBuilder;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity.FieldWithMetaCommodityBuilderImpl;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaCommodity.FieldWithMetaCommodityImpl;
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

public interface FieldWithMetaCommodity extends RosettaModelObject, FieldWithMeta<Commodity>, GlobalKey {
	FieldWithMetaCommodity build();
	FieldWithMetaCommodity.FieldWithMetaCommodityBuilder toBuilder();
	
	/**
	 */
	MetaFields getMeta();
	/**
	 */
	Commodity getValue();
	final static FieldWithMetaCommodityMeta metaData = new FieldWithMetaCommodityMeta();
	
	@Override
	default RosettaMetaData<? extends FieldWithMetaCommodity> metaData() {
		return metaData;
	} 
			
	static FieldWithMetaCommodity.FieldWithMetaCommodityBuilder builder() {
		return new FieldWithMetaCommodity.FieldWithMetaCommodityBuilderImpl();
	}
	
	default Class<? extends FieldWithMetaCommodity> getType() {
		return FieldWithMetaCommodity.class;
	}
	
		default Class<Commodity> getValueType() {
			return Commodity.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("value"), processor, Commodity.class, getValue());
	}
	
	
	interface FieldWithMetaCommodityBuilder extends FieldWithMetaCommodity, RosettaModelObjectBuilder, GlobalKeyBuilder, FieldWithMetaBuilder<Commodity> {
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Commodity.CommodityBuilder getOrCreateValue();
		Commodity.CommodityBuilder getValue();
		FieldWithMetaCommodity.FieldWithMetaCommodityBuilder setMeta(MetaFields meta);
		FieldWithMetaCommodity.FieldWithMetaCommodityBuilder setValue(Commodity value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("value"), processor, Commodity.CommodityBuilder.class, getValue());
		}
		
	}
	
	//FieldWithMetaCommodity.FieldWithMetaCommodityImpl
	class FieldWithMetaCommodityImpl implements FieldWithMetaCommodity {
		private final MetaFields meta;
		private final Commodity value;
		
		protected FieldWithMetaCommodityImpl(FieldWithMetaCommodity.FieldWithMetaCommodityBuilder builder) {
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public Commodity getValue() {
			return value;
		}
		
		@Override
		public FieldWithMetaCommodity build() {
			return this;
		}
		
		@Override
		public FieldWithMetaCommodity.FieldWithMetaCommodityBuilder toBuilder() {
			FieldWithMetaCommodity.FieldWithMetaCommodityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FieldWithMetaCommodity.FieldWithMetaCommodityBuilder builder) {
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCommodity _that = getType().cast(o);
		
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
			return "FieldWithMetaCommodity {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//FieldWithMetaCommodity.FieldWithMetaCommodityBuilderImpl
	class FieldWithMetaCommodityBuilderImpl implements FieldWithMetaCommodity.FieldWithMetaCommodityBuilder {
	
		protected MetaFields.MetaFieldsBuilder meta;
		protected Commodity.CommodityBuilder value;
	
		public FieldWithMetaCommodityBuilderImpl() {
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
		public Commodity.CommodityBuilder getValue() {
			return value;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateValue() {
			Commodity.CommodityBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = Commodity.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FieldWithMetaCommodity.FieldWithMetaCommodityBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public FieldWithMetaCommodity.FieldWithMetaCommodityBuilder setValue(Commodity value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public FieldWithMetaCommodity build() {
			return new FieldWithMetaCommodity.FieldWithMetaCommodityImpl(this);
		}
		
		@Override
		public FieldWithMetaCommodity.FieldWithMetaCommodityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FieldWithMetaCommodity.FieldWithMetaCommodityBuilder prune() {
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
		public FieldWithMetaCommodity.FieldWithMetaCommodityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FieldWithMetaCommodity.FieldWithMetaCommodityBuilder o = (FieldWithMetaCommodity.FieldWithMetaCommodityBuilder) other;
			
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FieldWithMetaCommodity _that = getType().cast(o);
		
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
			return "FieldWithMetaCommodityBuilder {" +
				"meta=" + this.meta + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class FieldWithMetaCommodityMeta extends BasicRosettaMetaData<FieldWithMetaCommodity>{

}
