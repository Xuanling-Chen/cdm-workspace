package cdm.legalagreement.csa;

import cdm.base.staticdata.identifier.Identifier;
import cdm.legalagreement.csa.meta.EligibleCollateralScheduleMeta;
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
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Set of criteria used to specify an eligible collateral schedule.
 * @version ${project.version}
 */
@RosettaClass

public interface EligibleCollateralSchedule extends RosettaModelObject, GlobalKey {
	EligibleCollateralSchedule build();
	EligibleCollateralSchedule.EligibleCollateralScheduleBuilder toBuilder();
	
	/**
	 * Criteria used to specify eligible collateral.
	 */
	List<? extends EligibleCollateralCriteria> getCriteria();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Represents the identifier(s) that uniquely identify an eligible collateral schedule for an identity issuer.
	 */
	List<? extends Identifier> getScheduleIdentifier();
	final static EligibleCollateralScheduleMeta metaData = new EligibleCollateralScheduleMeta();
	
	@Override
	default RosettaMetaData<? extends EligibleCollateralSchedule> metaData() {
		return metaData;
	} 
			
	static EligibleCollateralSchedule.EligibleCollateralScheduleBuilder builder() {
		return new EligibleCollateralSchedule.EligibleCollateralScheduleBuilderImpl();
	}
	
	default Class<? extends EligibleCollateralSchedule> getType() {
		return EligibleCollateralSchedule.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("criteria"), processor, EligibleCollateralCriteria.class, getCriteria());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("scheduleIdentifier"), processor, Identifier.class, getScheduleIdentifier());
	}
	
	
	interface EligibleCollateralScheduleBuilder extends EligibleCollateralSchedule, RosettaModelObjectBuilder {
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder getOrCreateCriteria(int _index);
		List<? extends EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> getCriteria();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		Identifier.IdentifierBuilder getOrCreateScheduleIdentifier(int _index);
		List<? extends Identifier.IdentifierBuilder> getScheduleIdentifier();
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addCriteria(EligibleCollateralCriteria criteria);
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addCriteria(EligibleCollateralCriteria criteria, int _idx);
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addCriteria(List<? extends EligibleCollateralCriteria> criteria);
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder setCriteria(List<? extends EligibleCollateralCriteria> criteria);
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder setMeta(MetaFields meta);
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addScheduleIdentifier(Identifier scheduleIdentifier);
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addScheduleIdentifier(Identifier scheduleIdentifier, int _idx);
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addScheduleIdentifier(List<? extends Identifier> scheduleIdentifier);
		EligibleCollateralSchedule.EligibleCollateralScheduleBuilder setScheduleIdentifier(List<? extends Identifier> scheduleIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("criteria"), processor, EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder.class, getCriteria());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("scheduleIdentifier"), processor, Identifier.IdentifierBuilder.class, getScheduleIdentifier());
		}
		
	}
	
	//EligibleCollateralSchedule.EligibleCollateralScheduleImpl
	class EligibleCollateralScheduleImpl implements EligibleCollateralSchedule {
		private final List<? extends EligibleCollateralCriteria> criteria;
		private final MetaFields meta;
		private final List<? extends Identifier> scheduleIdentifier;
		
		protected EligibleCollateralScheduleImpl(EligibleCollateralSchedule.EligibleCollateralScheduleBuilder builder) {
			this.criteria = ofNullable(builder.getCriteria()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.scheduleIdentifier = ofNullable(builder.getScheduleIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends EligibleCollateralCriteria> getCriteria() {
			return criteria;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends Identifier> getScheduleIdentifier() {
			return scheduleIdentifier;
		}
		
		@Override
		public EligibleCollateralSchedule build() {
			return this;
		}
		
		@Override
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder toBuilder() {
			EligibleCollateralSchedule.EligibleCollateralScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EligibleCollateralSchedule.EligibleCollateralScheduleBuilder builder) {
			ofNullable(getCriteria()).ifPresent(builder::setCriteria);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getScheduleIdentifier()).ifPresent(builder::setScheduleIdentifier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibleCollateralSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(criteria, _that.getCriteria())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(scheduleIdentifier, _that.getScheduleIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (criteria != null ? criteria.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (scheduleIdentifier != null ? scheduleIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralSchedule {" +
				"criteria=" + this.criteria + ", " +
				"meta=" + this.meta + ", " +
				"scheduleIdentifier=" + this.scheduleIdentifier +
			'}';
		}
	}
	
	//EligibleCollateralSchedule.EligibleCollateralScheduleBuilderImpl
	class EligibleCollateralScheduleBuilderImpl implements EligibleCollateralSchedule.EligibleCollateralScheduleBuilder, GlobalKeyBuilder {
	
		protected List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> criteria = new ArrayList<>();
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<Identifier.IdentifierBuilder> scheduleIdentifier = new ArrayList<>();
	
		public EligibleCollateralScheduleBuilderImpl() {
		}
	
		@Override
		public List<? extends EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> getCriteria() {
			return criteria;
		}
		
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder getOrCreateCriteria(int _index) {
		
			if (criteria==null) {
				this.criteria = new ArrayList<>();
			}
			EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder result;
			return getIndex(criteria, _index, () -> {
						EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder newCriteria = EligibleCollateralCriteria.builder();
						return newCriteria;
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
		public List<? extends Identifier.IdentifierBuilder> getScheduleIdentifier() {
			return scheduleIdentifier;
		}
		
		public Identifier.IdentifierBuilder getOrCreateScheduleIdentifier(int _index) {
		
			if (scheduleIdentifier==null) {
				this.scheduleIdentifier = new ArrayList<>();
			}
			Identifier.IdentifierBuilder result;
			return getIndex(scheduleIdentifier, _index, () -> {
						Identifier.IdentifierBuilder newScheduleIdentifier = Identifier.builder();
						return newScheduleIdentifier;
					});
		}
		
	
		@Override
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addCriteria(EligibleCollateralCriteria criteria) {
			if (criteria!=null) this.criteria.add(criteria.toBuilder());
			return this;
		}
		
		@Override
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addCriteria(EligibleCollateralCriteria criteria, int _idx) {
			getIndex(this.criteria, _idx, () -> criteria.toBuilder());
			return this;
		}
		@Override 
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addCriteria(List<? extends EligibleCollateralCriteria> criterias) {
			if (criterias != null) {
				for (EligibleCollateralCriteria toAdd : criterias) {
					this.criteria.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder setCriteria(List<? extends EligibleCollateralCriteria> criterias) {
			if (criterias == null)  {
				this.criteria = new ArrayList<>();
			}
			else {
				this.criteria = criterias.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addScheduleIdentifier(Identifier scheduleIdentifier) {
			if (scheduleIdentifier!=null) this.scheduleIdentifier.add(scheduleIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addScheduleIdentifier(Identifier scheduleIdentifier, int _idx) {
			getIndex(this.scheduleIdentifier, _idx, () -> scheduleIdentifier.toBuilder());
			return this;
		}
		@Override 
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder addScheduleIdentifier(List<? extends Identifier> scheduleIdentifiers) {
			if (scheduleIdentifiers != null) {
				for (Identifier toAdd : scheduleIdentifiers) {
					this.scheduleIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder setScheduleIdentifier(List<? extends Identifier> scheduleIdentifiers) {
			if (scheduleIdentifiers == null)  {
				this.scheduleIdentifier = new ArrayList<>();
			}
			else {
				this.scheduleIdentifier = scheduleIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public EligibleCollateralSchedule build() {
			return new EligibleCollateralSchedule.EligibleCollateralScheduleImpl(this);
		}
		
		@Override
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder prune() {
			criteria = criteria.stream().filter(b->b!=null).<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (meta!=null && !meta.prune().hasData()) meta = null;
			scheduleIdentifier = scheduleIdentifier.stream().filter(b->b!=null).<Identifier.IdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCriteria()!=null && getCriteria().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getScheduleIdentifier()!=null && getScheduleIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralSchedule.EligibleCollateralScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EligibleCollateralSchedule.EligibleCollateralScheduleBuilder o = (EligibleCollateralSchedule.EligibleCollateralScheduleBuilder) other;
			
			merger.mergeRosetta(getCriteria(), o.getCriteria(), this::getOrCreateCriteria);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getScheduleIdentifier(), o.getScheduleIdentifier(), this::getOrCreateScheduleIdentifier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EligibleCollateralSchedule _that = getType().cast(o);
		
			if (!ListEquals.listEquals(criteria, _that.getCriteria())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(scheduleIdentifier, _that.getScheduleIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (criteria != null ? criteria.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (scheduleIdentifier != null ? scheduleIdentifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralScheduleBuilder {" +
				"criteria=" + this.criteria + ", " +
				"meta=" + this.meta + ", " +
				"scheduleIdentifier=" + this.scheduleIdentifier +
			'}';
		}
	}
}
