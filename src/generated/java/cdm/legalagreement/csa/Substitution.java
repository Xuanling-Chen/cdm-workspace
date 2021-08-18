package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.SubstitutionMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the conditions under which the Security Provider can substitute posted collateral.
 * @version ${project.version}
 */
@RosettaClass

public interface Substitution extends RosettaModelObject {
	Substitution build();
	Substitution.SubstitutionBuilder toBuilder();
	
	/**
	 * The election as to whether the Pledgor/Obligor/Chargor must obtain the Secured Party’s consent for any collateral substitution. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (f)(ii): Consent. | ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (f)(ii): Consent.
	 */
	Boolean getNeedsConsent();
	/**
	 * Specific consent language might be specified by the parties.
	 */
	String getSpecificConsentLanguage();
	/**
	 * Substiution   Date  has  the  meaning  specified  in  Paragraph4(d)(ii),   unless   otherwise   specified.
	 */
	String getSubstitutionDateLanguage();
	final static SubstitutionMeta metaData = new SubstitutionMeta();
	
	@Override
	default RosettaMetaData<? extends Substitution> metaData() {
		return metaData;
	} 
			
	static Substitution.SubstitutionBuilder builder() {
		return new Substitution.SubstitutionBuilderImpl();
	}
	
	default Class<? extends Substitution> getType() {
		return Substitution.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("needsConsent"), Boolean.class, getNeedsConsent(), this);
		processor.processBasic(path.newSubPath("specificConsentLanguage"), String.class, getSpecificConsentLanguage(), this);
		processor.processBasic(path.newSubPath("substitutionDateLanguage"), String.class, getSubstitutionDateLanguage(), this);
		
	}
	
	
	interface SubstitutionBuilder extends Substitution, RosettaModelObjectBuilder {
		Substitution.SubstitutionBuilder setNeedsConsent(Boolean needsConsent);
		Substitution.SubstitutionBuilder setSpecificConsentLanguage(String specificConsentLanguage);
		Substitution.SubstitutionBuilder setSubstitutionDateLanguage(String substitutionDateLanguage);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("needsConsent"), Boolean.class, getNeedsConsent(), this);
			processor.processBasic(path.newSubPath("specificConsentLanguage"), String.class, getSpecificConsentLanguage(), this);
			processor.processBasic(path.newSubPath("substitutionDateLanguage"), String.class, getSubstitutionDateLanguage(), this);
			
		}
		
	}
	
	//Substitution.SubstitutionImpl
	class SubstitutionImpl implements Substitution {
		private final Boolean needsConsent;
		private final String specificConsentLanguage;
		private final String substitutionDateLanguage;
		
		protected SubstitutionImpl(Substitution.SubstitutionBuilder builder) {
			this.needsConsent = builder.getNeedsConsent();
			this.specificConsentLanguage = builder.getSpecificConsentLanguage();
			this.substitutionDateLanguage = builder.getSubstitutionDateLanguage();
		}
		
		@Override
		public Boolean getNeedsConsent() {
			return needsConsent;
		}
		
		@Override
		public String getSpecificConsentLanguage() {
			return specificConsentLanguage;
		}
		
		@Override
		public String getSubstitutionDateLanguage() {
			return substitutionDateLanguage;
		}
		
		@Override
		public Substitution build() {
			return this;
		}
		
		@Override
		public Substitution.SubstitutionBuilder toBuilder() {
			Substitution.SubstitutionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Substitution.SubstitutionBuilder builder) {
			ofNullable(getNeedsConsent()).ifPresent(builder::setNeedsConsent);
			ofNullable(getSpecificConsentLanguage()).ifPresent(builder::setSpecificConsentLanguage);
			ofNullable(getSubstitutionDateLanguage()).ifPresent(builder::setSubstitutionDateLanguage);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Substitution _that = getType().cast(o);
		
			if (!Objects.equals(needsConsent, _that.getNeedsConsent())) return false;
			if (!Objects.equals(specificConsentLanguage, _that.getSpecificConsentLanguage())) return false;
			if (!Objects.equals(substitutionDateLanguage, _that.getSubstitutionDateLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (needsConsent != null ? needsConsent.hashCode() : 0);
			_result = 31 * _result + (specificConsentLanguage != null ? specificConsentLanguage.hashCode() : 0);
			_result = 31 * _result + (substitutionDateLanguage != null ? substitutionDateLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Substitution {" +
				"needsConsent=" + this.needsConsent + ", " +
				"specificConsentLanguage=" + this.specificConsentLanguage + ", " +
				"substitutionDateLanguage=" + this.substitutionDateLanguage +
			'}';
		}
	}
	
	//Substitution.SubstitutionBuilderImpl
	class SubstitutionBuilderImpl implements Substitution.SubstitutionBuilder {
	
		protected Boolean needsConsent;
		protected String specificConsentLanguage;
		protected String substitutionDateLanguage;
	
		public SubstitutionBuilderImpl() {
		}
	
		@Override
		public Boolean getNeedsConsent() {
			return needsConsent;
		}
		
		@Override
		public String getSpecificConsentLanguage() {
			return specificConsentLanguage;
		}
		
		@Override
		public String getSubstitutionDateLanguage() {
			return substitutionDateLanguage;
		}
		
	
		@Override
		public Substitution.SubstitutionBuilder setNeedsConsent(Boolean needsConsent) {
			this.needsConsent = needsConsent==null?null:needsConsent;
			return this;
		}
		@Override
		public Substitution.SubstitutionBuilder setSpecificConsentLanguage(String specificConsentLanguage) {
			this.specificConsentLanguage = specificConsentLanguage==null?null:specificConsentLanguage;
			return this;
		}
		@Override
		public Substitution.SubstitutionBuilder setSubstitutionDateLanguage(String substitutionDateLanguage) {
			this.substitutionDateLanguage = substitutionDateLanguage==null?null:substitutionDateLanguage;
			return this;
		}
		
		@Override
		public Substitution build() {
			return new Substitution.SubstitutionImpl(this);
		}
		
		@Override
		public Substitution.SubstitutionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Substitution.SubstitutionBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNeedsConsent()!=null) return true;
			if (getSpecificConsentLanguage()!=null) return true;
			if (getSubstitutionDateLanguage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Substitution.SubstitutionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Substitution.SubstitutionBuilder o = (Substitution.SubstitutionBuilder) other;
			
			
			merger.mergeBasic(getNeedsConsent(), o.getNeedsConsent(), this::setNeedsConsent);
			merger.mergeBasic(getSpecificConsentLanguage(), o.getSpecificConsentLanguage(), this::setSpecificConsentLanguage);
			merger.mergeBasic(getSubstitutionDateLanguage(), o.getSubstitutionDateLanguage(), this::setSubstitutionDateLanguage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Substitution _that = getType().cast(o);
		
			if (!Objects.equals(needsConsent, _that.getNeedsConsent())) return false;
			if (!Objects.equals(specificConsentLanguage, _that.getSpecificConsentLanguage())) return false;
			if (!Objects.equals(substitutionDateLanguage, _that.getSubstitutionDateLanguage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (needsConsent != null ? needsConsent.hashCode() : 0);
			_result = 31 * _result + (specificConsentLanguage != null ? specificConsentLanguage.hashCode() : 0);
			_result = 31 * _result + (substitutionDateLanguage != null ? substitutionDateLanguage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SubstitutionBuilder {" +
				"needsConsent=" + this.needsConsent + ", " +
				"specificConsentLanguage=" + this.specificConsentLanguage + ", " +
				"substitutionDateLanguage=" + this.substitutionDateLanguage +
			'}';
		}
	}
}
