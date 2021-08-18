package com.rosetta.model.metafields;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.GlobalKeyFields;
import com.rosetta.model.lib.meta.GlobalKeyFields.GlobalKeyFieldsBuilder;
import com.rosetta.model.lib.meta.Key;
import com.rosetta.model.lib.meta.MetaDataFields;
import com.rosetta.model.lib.meta.MetaDataFields.MetaDataFieldsBuilder;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilder;
import com.rosetta.model.metafields.MetaFields.MetaFieldsBuilderImpl;
import com.rosetta.model.metafields.MetaFields.MetaFieldsImpl;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface MetaFields extends RosettaModelObject, MetaDataFields, GlobalKeyFields {
	MetaFields build();
	MetaFields.MetaFieldsBuilder toBuilder();
	
	/**
	 */
	String getExternalKey();
	/**
	 */
	String getGlobalKey();
	/**
	 */
	List<? extends Key> getKey();
	/**
	 */
	String getScheme();
	final static MetaFieldsMeta metaData = new MetaFieldsMeta();
	
	@Override
	default RosettaMetaData<? extends MetaFields> metaData() {
		return metaData;
	} 
			
	static MetaFields.MetaFieldsBuilder builder() {
		return new MetaFields.MetaFieldsBuilderImpl();
	}
	
	default Class<? extends MetaFields> getType() {
		return MetaFields.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalKey"), String.class, getExternalKey(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalKey"), String.class, getGlobalKey(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("scheme"), String.class, getScheme(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("key"), processor, Key.class, getKey());
	}
	
	
	interface MetaFieldsBuilder extends MetaFields, RosettaModelObjectBuilder, GlobalKeyFieldsBuilder, MetaDataFieldsBuilder {
		Key.KeyBuilder getOrCreateKey(int _index);
		List<? extends Key.KeyBuilder> getKey();
		MetaFields.MetaFieldsBuilder setExternalKey(String externalKey);
		MetaFields.MetaFieldsBuilder setGlobalKey(String globalKey);
		MetaFields.MetaFieldsBuilder addKey(Key key);
		MetaFields.MetaFieldsBuilder addKey(Key key, int _idx);
		MetaFields.MetaFieldsBuilder addKey(List<? extends Key> key);
		MetaFields.MetaFieldsBuilder setKey(List<? extends Key> key);
		MetaFields.MetaFieldsBuilder setScheme(String scheme);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalKey"), String.class, getExternalKey(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalKey"), String.class, getGlobalKey(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("scheme"), String.class, getScheme(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("key"), processor, Key.KeyBuilder.class, getKey());
		}
		
	}
	
	//MetaFields.MetaFieldsImpl
	class MetaFieldsImpl implements MetaFields {
		private final String externalKey;
		private final String globalKey;
		private final List<? extends Key> key;
		private final String scheme;
		
		protected MetaFieldsImpl(MetaFields.MetaFieldsBuilder builder) {
			this.externalKey = builder.getExternalKey();
			this.globalKey = builder.getGlobalKey();
			this.key = ofNullable(builder.getKey()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.scheme = builder.getScheme();
		}
		
		@Override
		public String getExternalKey() {
			return externalKey;
		}
		
		@Override
		public String getGlobalKey() {
			return globalKey;
		}
		
		@Override
		public List<? extends Key> getKey() {
			return key;
		}
		
		@Override
		public String getScheme() {
			return scheme;
		}
		
		@Override
		public MetaFields build() {
			return this;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder toBuilder() {
			MetaFields.MetaFieldsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MetaFields.MetaFieldsBuilder builder) {
			ofNullable(getExternalKey()).ifPresent(builder::setExternalKey);
			ofNullable(getGlobalKey()).ifPresent(builder::setGlobalKey);
			ofNullable(getKey()).ifPresent(builder::setKey);
			ofNullable(getScheme()).ifPresent(builder::setScheme);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetaFields _that = getType().cast(o);
		
			if (!Objects.equals(externalKey, _that.getExternalKey())) return false;
			if (!Objects.equals(globalKey, _that.getGlobalKey())) return false;
			if (!ListEquals.listEquals(key, _that.getKey())) return false;
			if (!Objects.equals(scheme, _that.getScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalKey != null ? externalKey.hashCode() : 0);
			_result = 31 * _result + (globalKey != null ? globalKey.hashCode() : 0);
			_result = 31 * _result + (key != null ? key.hashCode() : 0);
			_result = 31 * _result + (scheme != null ? scheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetaFields {" +
				"externalKey=" + this.externalKey + ", " +
				"globalKey=" + this.globalKey + ", " +
				"key=" + this.key + ", " +
				"scheme=" + this.scheme +
			'}';
		}
	}
	
	//MetaFields.MetaFieldsBuilderImpl
	class MetaFieldsBuilderImpl implements MetaFields.MetaFieldsBuilder {
	
		protected String externalKey;
		protected String globalKey;
		protected List<Key.KeyBuilder> key = new ArrayList<>();
		protected String scheme;
	
		public MetaFieldsBuilderImpl() {
		}
	
		@Override
		public String getExternalKey() {
			return externalKey;
		}
		
		@Override
		public String getGlobalKey() {
			return globalKey;
		}
		
		@Override
		public List<? extends Key.KeyBuilder> getKey() {
			return key;
		}
		
		public Key.KeyBuilder getOrCreateKey(int _index) {
		
			if (key==null) {
				this.key = new ArrayList<>();
			}
			Key.KeyBuilder result;
			return getIndex(key, _index, () -> {
						Key.KeyBuilder newKey = Key.builder();
						return newKey;
					});
		}
		
		@Override
		public String getScheme() {
			return scheme;
		}
		
	
		@Override
		public MetaFields.MetaFieldsBuilder setExternalKey(String externalKey) {
			this.externalKey = externalKey==null?null:externalKey;
			return this;
		}
		@Override
		public MetaFields.MetaFieldsBuilder setGlobalKey(String globalKey) {
			this.globalKey = globalKey==null?null:globalKey;
			return this;
		}
		@Override
		public MetaFields.MetaFieldsBuilder addKey(Key key) {
			if (key!=null) this.key.add(key.toBuilder());
			return this;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder addKey(Key key, int _idx) {
			getIndex(this.key, _idx, () -> key.toBuilder());
			return this;
		}
		@Override 
		public MetaFields.MetaFieldsBuilder addKey(List<? extends Key> keys) {
			if (keys != null) {
				for (Key toAdd : keys) {
					this.key.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MetaFields.MetaFieldsBuilder setKey(List<? extends Key> keys) {
			if (keys == null)  {
				this.key = new ArrayList<>();
			}
			else {
				this.key = keys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder setScheme(String scheme) {
			this.scheme = scheme==null?null:scheme;
			return this;
		}
		
		@Override
		public MetaFields build() {
			return new MetaFields.MetaFieldsImpl(this);
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetaFields.MetaFieldsBuilder prune() {
			key = key.stream().filter(b->b!=null).<Key.KeyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExternalKey()!=null) return true;
			if (getGlobalKey()!=null) return true;
			if (getKey()!=null && getKey().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetaFields.MetaFieldsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MetaFields.MetaFieldsBuilder o = (MetaFields.MetaFieldsBuilder) other;
			
			merger.mergeRosetta(getKey(), o.getKey(), this::getOrCreateKey);
			
			merger.mergeBasic(getExternalKey(), o.getExternalKey(), this::setExternalKey);
			merger.mergeBasic(getGlobalKey(), o.getGlobalKey(), this::setGlobalKey);
			merger.mergeBasic(getScheme(), o.getScheme(), this::setScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetaFields _that = getType().cast(o);
		
			if (!Objects.equals(externalKey, _that.getExternalKey())) return false;
			if (!Objects.equals(globalKey, _that.getGlobalKey())) return false;
			if (!ListEquals.listEquals(key, _that.getKey())) return false;
			if (!Objects.equals(scheme, _that.getScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalKey != null ? externalKey.hashCode() : 0);
			_result = 31 * _result + (globalKey != null ? globalKey.hashCode() : 0);
			_result = 31 * _result + (key != null ? key.hashCode() : 0);
			_result = 31 * _result + (scheme != null ? scheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetaFieldsBuilder {" +
				"externalKey=" + this.externalKey + ", " +
				"globalKey=" + this.globalKey + ", " +
				"key=" + this.key + ", " +
				"scheme=" + this.scheme +
			'}';
		}
	}
}

class MetaFieldsMeta extends BasicRosettaMetaData<MetaFields>{

}
