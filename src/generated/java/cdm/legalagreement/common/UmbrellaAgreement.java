package cdm.legalagreement.common;

import cdm.legalagreement.common.meta.UmbrellaAgreementMeta;
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
 * A class to specify a set of legal entities which are part of a legal agreement beyond the two contracting parties to that agreement. This data representation reflects the ISDA Create representation.
 * @version ${project.version}
 */
@RosettaClass

public interface UmbrellaAgreement extends RosettaModelObject {
	UmbrellaAgreement build();
	UmbrellaAgreement.UmbrellaAgreementBuilder toBuilder();
	
	/**
	 * The determination of whether Umbrella Agreement terms are Applicable (True), or Not Applicable (False)
	 */
	Boolean getIsApplicable();
	/**
	 * The language associated with the umbrella agreement, and which applies to all the parties to the umbrella agreement.
	 */
	String getLanguage();
	/**
	 * Underlying principals to the umbrella agreement.
	 */
	List<? extends UmbrellaAgreementEntity> getParties();
	final static UmbrellaAgreementMeta metaData = new UmbrellaAgreementMeta();
	
	@Override
	default RosettaMetaData<? extends UmbrellaAgreement> metaData() {
		return metaData;
	} 
			
	static UmbrellaAgreement.UmbrellaAgreementBuilder builder() {
		return new UmbrellaAgreement.UmbrellaAgreementBuilderImpl();
	}
	
	default Class<? extends UmbrellaAgreement> getType() {
		return UmbrellaAgreement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
		processor.processBasic(path.newSubPath("language"), String.class, getLanguage(), this);
		
		processRosetta(path.newSubPath("parties"), processor, UmbrellaAgreementEntity.class, getParties());
	}
	
	
	interface UmbrellaAgreementBuilder extends UmbrellaAgreement, RosettaModelObjectBuilder {
		UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder getOrCreateParties(int _index);
		List<? extends UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder> getParties();
		UmbrellaAgreement.UmbrellaAgreementBuilder setIsApplicable(Boolean isApplicable);
		UmbrellaAgreement.UmbrellaAgreementBuilder setLanguage(String language);
		UmbrellaAgreement.UmbrellaAgreementBuilder addParties(UmbrellaAgreementEntity parties);
		UmbrellaAgreement.UmbrellaAgreementBuilder addParties(UmbrellaAgreementEntity parties, int _idx);
		UmbrellaAgreement.UmbrellaAgreementBuilder addParties(List<? extends UmbrellaAgreementEntity> parties);
		UmbrellaAgreement.UmbrellaAgreementBuilder setParties(List<? extends UmbrellaAgreementEntity> parties);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isApplicable"), Boolean.class, getIsApplicable(), this);
			processor.processBasic(path.newSubPath("language"), String.class, getLanguage(), this);
			
			processRosetta(path.newSubPath("parties"), processor, UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder.class, getParties());
		}
		
	}
	
	//UmbrellaAgreement.UmbrellaAgreementImpl
	class UmbrellaAgreementImpl implements UmbrellaAgreement {
		private final Boolean isApplicable;
		private final String language;
		private final List<? extends UmbrellaAgreementEntity> parties;
		
		protected UmbrellaAgreementImpl(UmbrellaAgreement.UmbrellaAgreementBuilder builder) {
			this.isApplicable = builder.getIsApplicable();
			this.language = builder.getLanguage();
			this.parties = ofNullable(builder.getParties()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public String getLanguage() {
			return language;
		}
		
		@Override
		public List<? extends UmbrellaAgreementEntity> getParties() {
			return parties;
		}
		
		@Override
		public UmbrellaAgreement build() {
			return this;
		}
		
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder toBuilder() {
			UmbrellaAgreement.UmbrellaAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UmbrellaAgreement.UmbrellaAgreementBuilder builder) {
			ofNullable(getIsApplicable()).ifPresent(builder::setIsApplicable);
			ofNullable(getLanguage()).ifPresent(builder::setLanguage);
			ofNullable(getParties()).ifPresent(builder::setParties);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UmbrellaAgreement _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(language, _that.getLanguage())) return false;
			if (!ListEquals.listEquals(parties, _that.getParties())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (language != null ? language.hashCode() : 0);
			_result = 31 * _result + (parties != null ? parties.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UmbrellaAgreement {" +
				"isApplicable=" + this.isApplicable + ", " +
				"language=" + this.language + ", " +
				"parties=" + this.parties +
			'}';
		}
	}
	
	//UmbrellaAgreement.UmbrellaAgreementBuilderImpl
	class UmbrellaAgreementBuilderImpl implements UmbrellaAgreement.UmbrellaAgreementBuilder {
	
		protected Boolean isApplicable;
		protected String language;
		protected List<UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder> parties = new ArrayList<>();
	
		public UmbrellaAgreementBuilderImpl() {
		}
	
		@Override
		public Boolean getIsApplicable() {
			return isApplicable;
		}
		
		@Override
		public String getLanguage() {
			return language;
		}
		
		@Override
		public List<? extends UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder> getParties() {
			return parties;
		}
		
		public UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder getOrCreateParties(int _index) {
		
			if (parties==null) {
				this.parties = new ArrayList<>();
			}
			UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder result;
			return getIndex(parties, _index, () -> {
						UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder newParties = UmbrellaAgreementEntity.builder();
						return newParties;
					});
		}
		
	
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder setIsApplicable(Boolean isApplicable) {
			this.isApplicable = isApplicable==null?null:isApplicable;
			return this;
		}
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder setLanguage(String language) {
			this.language = language==null?null:language;
			return this;
		}
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder addParties(UmbrellaAgreementEntity parties) {
			if (parties!=null) this.parties.add(parties.toBuilder());
			return this;
		}
		
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder addParties(UmbrellaAgreementEntity parties, int _idx) {
			getIndex(this.parties, _idx, () -> parties.toBuilder());
			return this;
		}
		@Override 
		public UmbrellaAgreement.UmbrellaAgreementBuilder addParties(List<? extends UmbrellaAgreementEntity> partiess) {
			if (partiess != null) {
				for (UmbrellaAgreementEntity toAdd : partiess) {
					this.parties.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public UmbrellaAgreement.UmbrellaAgreementBuilder setParties(List<? extends UmbrellaAgreementEntity> partiess) {
			if (partiess == null)  {
				this.parties = new ArrayList<>();
			}
			else {
				this.parties = partiess.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public UmbrellaAgreement build() {
			return new UmbrellaAgreement.UmbrellaAgreementImpl(this);
		}
		
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder prune() {
			parties = parties.stream().filter(b->b!=null).<UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIsApplicable()!=null) return true;
			if (getLanguage()!=null) return true;
			if (getParties()!=null && getParties().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UmbrellaAgreement.UmbrellaAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UmbrellaAgreement.UmbrellaAgreementBuilder o = (UmbrellaAgreement.UmbrellaAgreementBuilder) other;
			
			merger.mergeRosetta(getParties(), o.getParties(), this::getOrCreateParties);
			
			merger.mergeBasic(getIsApplicable(), o.getIsApplicable(), this::setIsApplicable);
			merger.mergeBasic(getLanguage(), o.getLanguage(), this::setLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UmbrellaAgreement _that = getType().cast(o);
		
			if (!Objects.equals(isApplicable, _that.getIsApplicable())) return false;
			if (!Objects.equals(language, _that.getLanguage())) return false;
			if (!ListEquals.listEquals(parties, _that.getParties())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (isApplicable != null ? isApplicable.hashCode() : 0);
			_result = 31 * _result + (language != null ? language.hashCode() : 0);
			_result = 31 * _result + (parties != null ? parties.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UmbrellaAgreementBuilder {" +
				"isApplicable=" + this.isApplicable + ", " +
				"language=" + this.language + ", " +
				"parties=" + this.parties +
			'}';
		}
	}
}
