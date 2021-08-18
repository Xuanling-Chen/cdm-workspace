package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.LegalEntityMeta;
import com.google.common.collect.ImmutableList;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.FieldWithMetaString.FieldWithMetaStringBuilder;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class to specify a legal entity, with a required name and an optional entity identifier (such as the LEI).
 * @version ${project.version}
 */
@RosettaClass

public interface LegalEntity extends RosettaModelObject, GlobalKey {
	LegalEntity build();
	LegalEntity.LegalEntityBuilder toBuilder();
	
	/**
	 * A legal entity identifier (e.g. RED entity code).
	 */
	List<? extends FieldWithMetaString> getEntityId();
	/**
	 */
	MetaFields getMeta();
	/**
	 * The legal entity name.
	 */
	FieldWithMetaString getName();
	final static LegalEntityMeta metaData = new LegalEntityMeta();
	
	@Override
	default RosettaMetaData<? extends LegalEntity> metaData() {
		return metaData;
	} 
			
	static LegalEntity.LegalEntityBuilder builder() {
		return new LegalEntity.LegalEntityBuilderImpl();
	}
	
	default Class<? extends LegalEntity> getType() {
		return LegalEntity.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("entityId"), processor, FieldWithMetaString.class, getEntityId());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("name"), processor, FieldWithMetaString.class, getName());
	}
	
	
	interface LegalEntityBuilder extends LegalEntity, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateEntityId(int _index);
		List<? extends FieldWithMetaStringBuilder> getEntityId();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		FieldWithMetaStringBuilder getOrCreateName();
		FieldWithMetaStringBuilder getName();
		LegalEntity.LegalEntityBuilder addEntityId(FieldWithMetaString entityId);
		LegalEntity.LegalEntityBuilder addEntityId(FieldWithMetaString entityId, int _idx);
		LegalEntity.LegalEntityBuilder addEntityIdValue(String entityId);
		LegalEntity.LegalEntityBuilder addEntityIdValue(String entityId, int _idx);
		LegalEntity.LegalEntityBuilder addEntityId(List<? extends FieldWithMetaString> entityId);
		LegalEntity.LegalEntityBuilder setEntityId(List<? extends FieldWithMetaString> entityId);
		LegalEntity.LegalEntityBuilder addEntityIdValue(List<? extends String> entityId);
		LegalEntity.LegalEntityBuilder setEntityIdValue(List<? extends String> entityId);
		LegalEntity.LegalEntityBuilder setMeta(MetaFields meta);
		LegalEntity.LegalEntityBuilder setName(FieldWithMetaString name);
		LegalEntity.LegalEntityBuilder setNameValue(String name);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("entityId"), processor, FieldWithMetaStringBuilder.class, getEntityId());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("name"), processor, FieldWithMetaStringBuilder.class, getName());
		}
		
	}
	
	//LegalEntity.LegalEntityImpl
	class LegalEntityImpl implements LegalEntity {
		private final List<? extends FieldWithMetaString> entityId;
		private final MetaFields meta;
		private final FieldWithMetaString name;
		
		protected LegalEntityImpl(LegalEntity.LegalEntityBuilder builder) {
			this.entityId = ofNullable(builder.getEntityId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.name = ofNullable(builder.getName()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends FieldWithMetaString> getEntityId() {
			return entityId;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public FieldWithMetaString getName() {
			return name;
		}
		
		@Override
		public LegalEntity build() {
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder toBuilder() {
			LegalEntity.LegalEntityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LegalEntity.LegalEntityBuilder builder) {
			ofNullable(getEntityId()).ifPresent(builder::setEntityId);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getName()).ifPresent(builder::setName);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntity {" +
				"entityId=" + this.entityId + ", " +
				"meta=" + this.meta + ", " +
				"name=" + this.name +
			'}';
		}
	}
	
	//LegalEntity.LegalEntityBuilderImpl
	class LegalEntityBuilderImpl implements LegalEntity.LegalEntityBuilder, GlobalKeyBuilder {
	
		protected List<FieldWithMetaStringBuilder> entityId = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		protected FieldWithMetaStringBuilder name;
	
		public LegalEntityBuilderImpl() {
		}
	
		@Override
		public List<? extends FieldWithMetaStringBuilder> getEntityId() {
			return entityId;
		}
		
		public FieldWithMetaStringBuilder getOrCreateEntityId(int _index) {
		
			if (entityId==null) {
				this.entityId = new ArrayList<>();
			}
			FieldWithMetaStringBuilder result;
			return getIndex(entityId, _index, () -> {
						FieldWithMetaStringBuilder newEntityId = FieldWithMetaString.builder();
						return newEntityId;
					});
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
		public FieldWithMetaStringBuilder getName() {
			return name;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateName() {
			FieldWithMetaStringBuilder result;
			if (name!=null) {
				result = name;
			}
			else {
				result = name = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public LegalEntity.LegalEntityBuilder addEntityId(FieldWithMetaString entityId) {
			if (entityId!=null) this.entityId.add(entityId.toBuilder());
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityId(FieldWithMetaString entityId, int _idx) {
			getIndex(this.entityId, _idx, () -> entityId.toBuilder());
			return this;
		}
		
			@Override
			public LegalEntity.LegalEntityBuilder addEntityIdValue(String entityId) {
				this.getOrCreateEntityId(-1).setValue(entityId);
				return this;
			}
			
			@Override
			public LegalEntity.LegalEntityBuilder addEntityIdValue(String entityId, int _idx) {
				this.getOrCreateEntityId(_idx).setValue(entityId);
				return this;
			}
		@Override 
		public LegalEntity.LegalEntityBuilder addEntityId(List<? extends FieldWithMetaString> entityIds) {
			if (entityIds != null) {
				for (FieldWithMetaString toAdd : entityIds) {
					this.entityId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public LegalEntity.LegalEntityBuilder setEntityId(List<? extends FieldWithMetaString> entityIds) {
			if (entityIds == null)  {
				this.entityId = new ArrayList<>();
			}
			else {
				this.entityId = entityIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder addEntityIdValue(List<? extends String> entityIds) {
			if (entityIds != null) {
				for (String toAdd : entityIds) {
					this.addEntityIdValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder setEntityIdValue(List<? extends String> entityIds) {
			this.entityId.clear();
			if (entityIds!=null) {
				entityIds.forEach(this::addEntityIdValue);
			}
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public LegalEntity.LegalEntityBuilder setName(FieldWithMetaString name) {
			this.name = name==null?null:name.toBuilder();
			return this;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder setNameValue(String name) {
			this.getOrCreateName().setValue(name);
			return this;
		}
		
		@Override
		public LegalEntity build() {
			return new LegalEntity.LegalEntityImpl(this);
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntity.LegalEntityBuilder prune() {
			entityId = entityId.stream().filter(b->b!=null).<FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			if (name!=null && !name.prune().hasData()) name = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEntityId()!=null && !getEntityId().isEmpty()) return true;
			if (getName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LegalEntity.LegalEntityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LegalEntity.LegalEntityBuilder o = (LegalEntity.LegalEntityBuilder) other;
			
			merger.mergeRosetta(getEntityId(), o.getEntityId(), this::getOrCreateEntityId);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getName(), o.getName(), this::setName);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LegalEntity _that = getType().cast(o);
		
			if (!ListEquals.listEquals(entityId, _that.getEntityId())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (entityId != null ? entityId.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LegalEntityBuilder {" +
				"entityId=" + this.entityId + ", " +
				"meta=" + this.meta + ", " +
				"name=" + this.name +
			'}';
		}
	}
}
