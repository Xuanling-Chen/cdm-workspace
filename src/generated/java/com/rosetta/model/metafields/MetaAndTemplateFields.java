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
import com.rosetta.model.lib.meta.TemplateFields;
import com.rosetta.model.lib.meta.TemplateFields.TemplateFieldsBuilder;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaAndTemplateFields;
import com.rosetta.model.metafields.MetaAndTemplateFields.MetaAndTemplateFieldsBuilder;
import com.rosetta.model.metafields.MetaAndTemplateFields.MetaAndTemplateFieldsBuilderImpl;
import com.rosetta.model.metafields.MetaAndTemplateFields.MetaAndTemplateFieldsImpl;
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

public interface MetaAndTemplateFields extends RosettaModelObject, TemplateFields, MetaDataFields, GlobalKeyFields {
	MetaAndTemplateFields build();
	MetaAndTemplateFields.MetaAndTemplateFieldsBuilder toBuilder();
	
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
	/**
	 */
	String getTemplateGlobalReference();
	final static MetaAndTemplateFieldsMeta metaData = new MetaAndTemplateFieldsMeta();
	
	@Override
	default RosettaMetaData<? extends MetaAndTemplateFields> metaData() {
		return metaData;
	} 
			
	static MetaAndTemplateFields.MetaAndTemplateFieldsBuilder builder() {
		return new MetaAndTemplateFields.MetaAndTemplateFieldsBuilderImpl();
	}
	
	default Class<? extends MetaAndTemplateFields> getType() {
		return MetaAndTemplateFields.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalKey"), String.class, getExternalKey(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalKey"), String.class, getGlobalKey(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("scheme"), String.class, getScheme(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("templateGlobalReference"), String.class, getTemplateGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("key"), processor, Key.class, getKey());
	}
	
	
	interface MetaAndTemplateFieldsBuilder extends MetaAndTemplateFields, RosettaModelObjectBuilder, GlobalKeyFieldsBuilder, TemplateFieldsBuilder, MetaDataFieldsBuilder {
		Key.KeyBuilder getOrCreateKey(int _index);
		List<? extends Key.KeyBuilder> getKey();
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setExternalKey(String externalKey);
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setGlobalKey(String globalKey);
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder addKey(Key key);
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder addKey(Key key, int _idx);
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder addKey(List<? extends Key> key);
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setKey(List<? extends Key> key);
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setScheme(String scheme);
		MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setTemplateGlobalReference(String templateGlobalReference);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalKey"), String.class, getExternalKey(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalKey"), String.class, getGlobalKey(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("scheme"), String.class, getScheme(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("templateGlobalReference"), String.class, getTemplateGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("key"), processor, Key.KeyBuilder.class, getKey());
		}
		
	}
	
	//MetaAndTemplateFields.MetaAndTemplateFieldsImpl
	class MetaAndTemplateFieldsImpl implements MetaAndTemplateFields {
		private final String externalKey;
		private final String globalKey;
		private final List<? extends Key> key;
		private final String scheme;
		private final String templateGlobalReference;
		
		protected MetaAndTemplateFieldsImpl(MetaAndTemplateFields.MetaAndTemplateFieldsBuilder builder) {
			this.externalKey = builder.getExternalKey();
			this.globalKey = builder.getGlobalKey();
			this.key = ofNullable(builder.getKey()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.scheme = builder.getScheme();
			this.templateGlobalReference = builder.getTemplateGlobalReference();
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
		public String getTemplateGlobalReference() {
			return templateGlobalReference;
		}
		
		@Override
		public MetaAndTemplateFields build() {
			return this;
		}
		
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder toBuilder() {
			MetaAndTemplateFields.MetaAndTemplateFieldsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MetaAndTemplateFields.MetaAndTemplateFieldsBuilder builder) {
			ofNullable(getExternalKey()).ifPresent(builder::setExternalKey);
			ofNullable(getGlobalKey()).ifPresent(builder::setGlobalKey);
			ofNullable(getKey()).ifPresent(builder::setKey);
			ofNullable(getScheme()).ifPresent(builder::setScheme);
			ofNullable(getTemplateGlobalReference()).ifPresent(builder::setTemplateGlobalReference);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetaAndTemplateFields _that = getType().cast(o);
		
			if (!Objects.equals(externalKey, _that.getExternalKey())) return false;
			if (!Objects.equals(globalKey, _that.getGlobalKey())) return false;
			if (!ListEquals.listEquals(key, _that.getKey())) return false;
			if (!Objects.equals(scheme, _that.getScheme())) return false;
			if (!Objects.equals(templateGlobalReference, _that.getTemplateGlobalReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalKey != null ? externalKey.hashCode() : 0);
			_result = 31 * _result + (globalKey != null ? globalKey.hashCode() : 0);
			_result = 31 * _result + (key != null ? key.hashCode() : 0);
			_result = 31 * _result + (scheme != null ? scheme.hashCode() : 0);
			_result = 31 * _result + (templateGlobalReference != null ? templateGlobalReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetaAndTemplateFields {" +
				"externalKey=" + this.externalKey + ", " +
				"globalKey=" + this.globalKey + ", " +
				"key=" + this.key + ", " +
				"scheme=" + this.scheme + ", " +
				"templateGlobalReference=" + this.templateGlobalReference +
			'}';
		}
	}
	
	//MetaAndTemplateFields.MetaAndTemplateFieldsBuilderImpl
	class MetaAndTemplateFieldsBuilderImpl implements MetaAndTemplateFields.MetaAndTemplateFieldsBuilder {
	
		protected String externalKey;
		protected String globalKey;
		protected List<Key.KeyBuilder> key = new ArrayList<>();
		protected String scheme;
		protected String templateGlobalReference;
	
		public MetaAndTemplateFieldsBuilderImpl() {
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
		public String getTemplateGlobalReference() {
			return templateGlobalReference;
		}
		
	
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setExternalKey(String externalKey) {
			this.externalKey = externalKey==null?null:externalKey;
			return this;
		}
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setGlobalKey(String globalKey) {
			this.globalKey = globalKey==null?null:globalKey;
			return this;
		}
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder addKey(Key key) {
			if (key!=null) this.key.add(key.toBuilder());
			return this;
		}
		
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder addKey(Key key, int _idx) {
			getIndex(this.key, _idx, () -> key.toBuilder());
			return this;
		}
		@Override 
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder addKey(List<? extends Key> keys) {
			if (keys != null) {
				for (Key toAdd : keys) {
					this.key.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setKey(List<? extends Key> keys) {
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
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setScheme(String scheme) {
			this.scheme = scheme==null?null:scheme;
			return this;
		}
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder setTemplateGlobalReference(String templateGlobalReference) {
			this.templateGlobalReference = templateGlobalReference==null?null:templateGlobalReference;
			return this;
		}
		
		@Override
		public MetaAndTemplateFields build() {
			return new MetaAndTemplateFields.MetaAndTemplateFieldsImpl(this);
		}
		
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder prune() {
			key = key.stream().filter(b->b!=null).<Key.KeyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExternalKey()!=null) return true;
			if (getGlobalKey()!=null) return true;
			if (getKey()!=null && getKey().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getScheme()!=null) return true;
			if (getTemplateGlobalReference()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MetaAndTemplateFields.MetaAndTemplateFieldsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MetaAndTemplateFields.MetaAndTemplateFieldsBuilder o = (MetaAndTemplateFields.MetaAndTemplateFieldsBuilder) other;
			
			merger.mergeRosetta(getKey(), o.getKey(), this::getOrCreateKey);
			
			merger.mergeBasic(getExternalKey(), o.getExternalKey(), this::setExternalKey);
			merger.mergeBasic(getGlobalKey(), o.getGlobalKey(), this::setGlobalKey);
			merger.mergeBasic(getScheme(), o.getScheme(), this::setScheme);
			merger.mergeBasic(getTemplateGlobalReference(), o.getTemplateGlobalReference(), this::setTemplateGlobalReference);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MetaAndTemplateFields _that = getType().cast(o);
		
			if (!Objects.equals(externalKey, _that.getExternalKey())) return false;
			if (!Objects.equals(globalKey, _that.getGlobalKey())) return false;
			if (!ListEquals.listEquals(key, _that.getKey())) return false;
			if (!Objects.equals(scheme, _that.getScheme())) return false;
			if (!Objects.equals(templateGlobalReference, _that.getTemplateGlobalReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalKey != null ? externalKey.hashCode() : 0);
			_result = 31 * _result + (globalKey != null ? globalKey.hashCode() : 0);
			_result = 31 * _result + (key != null ? key.hashCode() : 0);
			_result = 31 * _result + (scheme != null ? scheme.hashCode() : 0);
			_result = 31 * _result + (templateGlobalReference != null ? templateGlobalReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MetaAndTemplateFieldsBuilder {" +
				"externalKey=" + this.externalKey + ", " +
				"globalKey=" + this.globalKey + ", " +
				"key=" + this.key + ", " +
				"scheme=" + this.scheme + ", " +
				"templateGlobalReference=" + this.templateGlobalReference +
			'}';
		}
	}
}

class MetaAndTemplateFieldsMeta extends BasicRosettaMetaData<MetaAndTemplateFields>{

}
