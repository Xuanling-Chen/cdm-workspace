package cdm.event.common;

import cdm.base.staticdata.party.CategoryEnum;
import cdm.base.staticdata.party.RelatedParty;
import cdm.event.common.meta.PackageInformationMeta;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A class defining additional information that may be recorded alongside a transaction package.
 * @version ${project.version}
 */
@RosettaClass

public interface PackageInformation extends RosettaModelObject {
	PackageInformation build();
	PackageInformation.PackageInformationBuilder toBuilder();
	
	/**
	 */
	List<? extends CategoryEnum> getCategory();
	/**
	 * specifies whether the transaction package is anticipated to be allocated.
	 */
	Boolean getIntentToAllocate();
	/**
	 * This may be used to identify one or more parties that perform a role as part of the transaction.
	 */
	List<? extends RelatedParty> getRelatedParty();
	final static PackageInformationMeta metaData = new PackageInformationMeta();
	
	@Override
	default RosettaMetaData<? extends PackageInformation> metaData() {
		return metaData;
	} 
			
	static PackageInformation.PackageInformationBuilder builder() {
		return new PackageInformation.PackageInformationBuilderImpl();
	}
	
	default Class<? extends PackageInformation> getType() {
		return PackageInformation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("category"), CategoryEnum.class, getCategory(), this);
		processor.processBasic(path.newSubPath("intentToAllocate"), Boolean.class, getIntentToAllocate(), this);
		
		processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.class, getRelatedParty());
	}
	
	
	interface PackageInformationBuilder extends PackageInformation, RosettaModelObjectBuilder {
		RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index);
		List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty();
		PackageInformation.PackageInformationBuilder addCategory(CategoryEnum category);
		PackageInformation.PackageInformationBuilder addCategory(CategoryEnum category, int _idx);
		PackageInformation.PackageInformationBuilder addCategory(List<? extends CategoryEnum> category);
		PackageInformation.PackageInformationBuilder setCategory(List<? extends CategoryEnum> category);
		PackageInformation.PackageInformationBuilder setIntentToAllocate(Boolean intentToAllocate);
		PackageInformation.PackageInformationBuilder addRelatedParty(RelatedParty relatedParty);
		PackageInformation.PackageInformationBuilder addRelatedParty(RelatedParty relatedParty, int _idx);
		PackageInformation.PackageInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedParty);
		PackageInformation.PackageInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedParty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("category"), CategoryEnum.class, getCategory(), this);
			processor.processBasic(path.newSubPath("intentToAllocate"), Boolean.class, getIntentToAllocate(), this);
			
			processRosetta(path.newSubPath("relatedParty"), processor, RelatedParty.RelatedPartyBuilder.class, getRelatedParty());
		}
		
	}
	
	//PackageInformation.PackageInformationImpl
	class PackageInformationImpl implements PackageInformation {
		private final List<? extends CategoryEnum> category;
		private final Boolean intentToAllocate;
		private final List<? extends RelatedParty> relatedParty;
		
		protected PackageInformationImpl(PackageInformation.PackageInformationBuilder builder) {
			this.category = ofNullable(builder.getCategory()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.intentToAllocate = builder.getIntentToAllocate();
			this.relatedParty = ofNullable(builder.getRelatedParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public List<? extends CategoryEnum> getCategory() {
			return category;
		}
		
		@Override
		public Boolean getIntentToAllocate() {
			return intentToAllocate;
		}
		
		@Override
		public List<? extends RelatedParty> getRelatedParty() {
			return relatedParty;
		}
		
		@Override
		public PackageInformation build() {
			return this;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder toBuilder() {
			PackageInformation.PackageInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PackageInformation.PackageInformationBuilder builder) {
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getIntentToAllocate()).ifPresent(builder::setIntentToAllocate);
			ofNullable(getRelatedParty()).ifPresent(builder::setRelatedParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!Objects.equals(intentToAllocate, _that.getIntentToAllocate())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (category != null ? category.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (intentToAllocate != null ? intentToAllocate.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageInformation {" +
				"category=" + this.category + ", " +
				"intentToAllocate=" + this.intentToAllocate + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}
	
	//PackageInformation.PackageInformationBuilderImpl
	class PackageInformationBuilderImpl implements PackageInformation.PackageInformationBuilder {
	
		protected List<CategoryEnum> category = new ArrayList<>();
		protected Boolean intentToAllocate;
		protected List<RelatedParty.RelatedPartyBuilder> relatedParty = new ArrayList<>();
	
		public PackageInformationBuilderImpl() {
		}
	
		@Override
		public List<? extends CategoryEnum> getCategory() {
			return category;
		}
		
		@Override
		public Boolean getIntentToAllocate() {
			return intentToAllocate;
		}
		
		@Override
		public List<? extends RelatedParty.RelatedPartyBuilder> getRelatedParty() {
			return relatedParty;
		}
		
		public RelatedParty.RelatedPartyBuilder getOrCreateRelatedParty(int _index) {
		
			if (relatedParty==null) {
				this.relatedParty = new ArrayList<>();
			}
			RelatedParty.RelatedPartyBuilder result;
			return getIndex(relatedParty, _index, () -> {
						RelatedParty.RelatedPartyBuilder newRelatedParty = RelatedParty.builder();
						return newRelatedParty;
					});
		}
		
	
		@Override
		public PackageInformation.PackageInformationBuilder addCategory(CategoryEnum category) {
			if (category!=null) this.category.add(category);
			return this;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder addCategory(CategoryEnum category, int _idx) {
			getIndex(this.category, _idx, () -> category);
			return this;
		}
		@Override 
		public PackageInformation.PackageInformationBuilder addCategory(List<? extends CategoryEnum> categorys) {
			if (categorys != null) {
				for (CategoryEnum toAdd : categorys) {
					this.category.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public PackageInformation.PackageInformationBuilder setCategory(List<? extends CategoryEnum> categorys) {
			if (categorys == null)  {
				this.category = new ArrayList<>();
			}
			else {
				this.category = categorys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder setIntentToAllocate(Boolean intentToAllocate) {
			this.intentToAllocate = intentToAllocate==null?null:intentToAllocate;
			return this;
		}
		@Override
		public PackageInformation.PackageInformationBuilder addRelatedParty(RelatedParty relatedParty) {
			if (relatedParty!=null) this.relatedParty.add(relatedParty.toBuilder());
			return this;
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder addRelatedParty(RelatedParty relatedParty, int _idx) {
			getIndex(this.relatedParty, _idx, () -> relatedParty.toBuilder());
			return this;
		}
		@Override 
		public PackageInformation.PackageInformationBuilder addRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys != null) {
				for (RelatedParty toAdd : relatedPartys) {
					this.relatedParty.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PackageInformation.PackageInformationBuilder setRelatedParty(List<? extends RelatedParty> relatedPartys) {
			if (relatedPartys == null)  {
				this.relatedParty = new ArrayList<>();
			}
			else {
				this.relatedParty = relatedPartys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PackageInformation build() {
			return new PackageInformation.PackageInformationImpl(this);
		}
		
		@Override
		public PackageInformation.PackageInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageInformation.PackageInformationBuilder prune() {
			relatedParty = relatedParty.stream().filter(b->b!=null).<RelatedParty.RelatedPartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCategory()!=null && !getCategory().isEmpty()) return true;
			if (getIntentToAllocate()!=null) return true;
			if (getRelatedParty()!=null && getRelatedParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PackageInformation.PackageInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PackageInformation.PackageInformationBuilder o = (PackageInformation.PackageInformationBuilder) other;
			
			merger.mergeRosetta(getRelatedParty(), o.getRelatedParty(), this::getOrCreateRelatedParty);
			
			merger.mergeBasic(getCategory(), o.getCategory(), (Consumer<CategoryEnum>) this::addCategory);
			merger.mergeBasic(getIntentToAllocate(), o.getIntentToAllocate(), this::setIntentToAllocate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PackageInformation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(category, _that.getCategory())) return false;
			if (!Objects.equals(intentToAllocate, _that.getIntentToAllocate())) return false;
			if (!ListEquals.listEquals(relatedParty, _that.getRelatedParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (category != null ? category.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			_result = 31 * _result + (intentToAllocate != null ? intentToAllocate.hashCode() : 0);
			_result = 31 * _result + (relatedParty != null ? relatedParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PackageInformationBuilder {" +
				"category=" + this.category + ", " +
				"intentToAllocate=" + this.intentToAllocate + ", " +
				"relatedParty=" + this.relatedParty +
			'}';
		}
	}
}
