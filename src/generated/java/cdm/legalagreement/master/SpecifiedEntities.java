package cdm.legalagreement.master;

import cdm.legalagreement.common.SpecifiedEntityClauseEnum;
import cdm.legalagreement.master.meta.SpecifiedEntitiesMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A provision that allows each party to specify its Specified Entities for certain Events of Default and Termination Events
 * @version ${project.version}
 */
@RosettaClass

public interface SpecifiedEntities extends RosettaModelObject {
	SpecifiedEntities build();
	SpecifiedEntities.SpecifiedEntitiesBuilder toBuilder();
	
	/**
	 * The party specific election of Specified Entities for the Event of Default or Termination Event specified.
	 */
	List<? extends SpecifiedEntity> getSpecifiedEntity();
	/**
	 * The Event of Default or Termination event for which Specified Entities terms are being defined.
	 */
	SpecifiedEntityClauseEnum getSpecifiedEntityClause();
	final static SpecifiedEntitiesMeta metaData = new SpecifiedEntitiesMeta();
	
	@Override
	default RosettaMetaData<? extends SpecifiedEntities> metaData() {
		return metaData;
	} 
			
	static SpecifiedEntities.SpecifiedEntitiesBuilder builder() {
		return new SpecifiedEntities.SpecifiedEntitiesBuilderImpl();
	}
	
	default Class<? extends SpecifiedEntities> getType() {
		return SpecifiedEntities.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("specifiedEntityClause"), SpecifiedEntityClauseEnum.class, getSpecifiedEntityClause(), this);
		
		processRosetta(path.newSubPath("specifiedEntity"), processor, SpecifiedEntity.class, getSpecifiedEntity());
	}
	
	
	interface SpecifiedEntitiesBuilder extends SpecifiedEntities, RosettaModelObjectBuilder {
		SpecifiedEntity.SpecifiedEntityBuilder getOrCreateSpecifiedEntity(int _index);
		List<? extends SpecifiedEntity.SpecifiedEntityBuilder> getSpecifiedEntity();
		SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(SpecifiedEntity specifiedEntity);
		SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(SpecifiedEntity specifiedEntity, int _idx);
		SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(List<? extends SpecifiedEntity> specifiedEntity);
		SpecifiedEntities.SpecifiedEntitiesBuilder setSpecifiedEntity(List<? extends SpecifiedEntity> specifiedEntity);
		SpecifiedEntities.SpecifiedEntitiesBuilder setSpecifiedEntityClause(SpecifiedEntityClauseEnum specifiedEntityClause);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("specifiedEntityClause"), SpecifiedEntityClauseEnum.class, getSpecifiedEntityClause(), this);
			
			processRosetta(path.newSubPath("specifiedEntity"), processor, SpecifiedEntity.SpecifiedEntityBuilder.class, getSpecifiedEntity());
		}
		
	}
	
	//SpecifiedEntities.SpecifiedEntitiesImpl
	class SpecifiedEntitiesImpl implements SpecifiedEntities {
		private final List<? extends SpecifiedEntity> specifiedEntity;
		private final SpecifiedEntityClauseEnum specifiedEntityClause;
		
		protected SpecifiedEntitiesImpl(SpecifiedEntities.SpecifiedEntitiesBuilder builder) {
			this.specifiedEntity = ofNullable(builder.getSpecifiedEntity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.specifiedEntityClause = builder.getSpecifiedEntityClause();
		}
		
		@Override
		public List<? extends SpecifiedEntity> getSpecifiedEntity() {
			return specifiedEntity;
		}
		
		@Override
		public SpecifiedEntityClauseEnum getSpecifiedEntityClause() {
			return specifiedEntityClause;
		}
		
		@Override
		public SpecifiedEntities build() {
			return this;
		}
		
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder toBuilder() {
			SpecifiedEntities.SpecifiedEntitiesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SpecifiedEntities.SpecifiedEntitiesBuilder builder) {
			ofNullable(getSpecifiedEntity()).ifPresent(builder::setSpecifiedEntity);
			ofNullable(getSpecifiedEntityClause()).ifPresent(builder::setSpecifiedEntityClause);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedEntities _that = getType().cast(o);
		
			if (!ListEquals.listEquals(specifiedEntity, _that.getSpecifiedEntity())) return false;
			if (!Objects.equals(specifiedEntityClause, _that.getSpecifiedEntityClause())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specifiedEntity != null ? specifiedEntity.hashCode() : 0);
			_result = 31 * _result + (specifiedEntityClause != null ? specifiedEntityClause.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedEntities {" +
				"specifiedEntity=" + this.specifiedEntity + ", " +
				"specifiedEntityClause=" + this.specifiedEntityClause +
			'}';
		}
	}
	
	//SpecifiedEntities.SpecifiedEntitiesBuilderImpl
	class SpecifiedEntitiesBuilderImpl implements SpecifiedEntities.SpecifiedEntitiesBuilder {
	
		protected List<SpecifiedEntity.SpecifiedEntityBuilder> specifiedEntity = new ArrayList<>();
		protected SpecifiedEntityClauseEnum specifiedEntityClause;
	
		public SpecifiedEntitiesBuilderImpl() {
		}
	
		@Override
		public List<? extends SpecifiedEntity.SpecifiedEntityBuilder> getSpecifiedEntity() {
			return specifiedEntity;
		}
		
		public SpecifiedEntity.SpecifiedEntityBuilder getOrCreateSpecifiedEntity(int _index) {
		
			if (specifiedEntity==null) {
				this.specifiedEntity = new ArrayList<>();
			}
			SpecifiedEntity.SpecifiedEntityBuilder result;
			return getIndex(specifiedEntity, _index, () -> {
						SpecifiedEntity.SpecifiedEntityBuilder newSpecifiedEntity = SpecifiedEntity.builder();
						return newSpecifiedEntity;
					});
		}
		
		@Override
		public SpecifiedEntityClauseEnum getSpecifiedEntityClause() {
			return specifiedEntityClause;
		}
		
	
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(SpecifiedEntity specifiedEntity) {
			if (specifiedEntity!=null) this.specifiedEntity.add(specifiedEntity.toBuilder());
			return this;
		}
		
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(SpecifiedEntity specifiedEntity, int _idx) {
			getIndex(this.specifiedEntity, _idx, () -> specifiedEntity.toBuilder());
			return this;
		}
		@Override 
		public SpecifiedEntities.SpecifiedEntitiesBuilder addSpecifiedEntity(List<? extends SpecifiedEntity> specifiedEntitys) {
			if (specifiedEntitys != null) {
				for (SpecifiedEntity toAdd : specifiedEntitys) {
					this.specifiedEntity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SpecifiedEntities.SpecifiedEntitiesBuilder setSpecifiedEntity(List<? extends SpecifiedEntity> specifiedEntitys) {
			if (specifiedEntitys == null)  {
				this.specifiedEntity = new ArrayList<>();
			}
			else {
				this.specifiedEntity = specifiedEntitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder setSpecifiedEntityClause(SpecifiedEntityClauseEnum specifiedEntityClause) {
			this.specifiedEntityClause = specifiedEntityClause==null?null:specifiedEntityClause;
			return this;
		}
		
		@Override
		public SpecifiedEntities build() {
			return new SpecifiedEntities.SpecifiedEntitiesImpl(this);
		}
		
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder prune() {
			specifiedEntity = specifiedEntity.stream().filter(b->b!=null).<SpecifiedEntity.SpecifiedEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSpecifiedEntity()!=null && getSpecifiedEntity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSpecifiedEntityClause()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SpecifiedEntities.SpecifiedEntitiesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SpecifiedEntities.SpecifiedEntitiesBuilder o = (SpecifiedEntities.SpecifiedEntitiesBuilder) other;
			
			merger.mergeRosetta(getSpecifiedEntity(), o.getSpecifiedEntity(), this::getOrCreateSpecifiedEntity);
			
			merger.mergeBasic(getSpecifiedEntityClause(), o.getSpecifiedEntityClause(), this::setSpecifiedEntityClause);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SpecifiedEntities _that = getType().cast(o);
		
			if (!ListEquals.listEquals(specifiedEntity, _that.getSpecifiedEntity())) return false;
			if (!Objects.equals(specifiedEntityClause, _that.getSpecifiedEntityClause())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (specifiedEntity != null ? specifiedEntity.hashCode() : 0);
			_result = 31 * _result + (specifiedEntityClause != null ? specifiedEntityClause.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SpecifiedEntitiesBuilder {" +
				"specifiedEntity=" + this.specifiedEntity + ", " +
				"specifiedEntityClause=" + this.specifiedEntityClause +
			'}';
		}
	}
}
