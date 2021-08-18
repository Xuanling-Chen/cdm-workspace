package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.JurisdictionRelatedTermsMeta;
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
 * A class to specify terms jurisdiction related terms.
 * @version ${project.version}
 */
@RosettaClass

public interface JurisdictionRelatedTerms extends RosettaModelObject {
	JurisdictionRelatedTerms build();
	JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder toBuilder();
	
	/**
	 * Classification of optional exclusive jurisdiction terms
	 */
	Boolean getExclusiveJurisdiction();
	/**
	 * The French Law Addendum Provisions specific to the agreement.
	 */
	FrenchLawAddendum getFrenchLawAddendum();
	/**
	 * The Japanese Securities Provisions election.
	 */
	JapaneseSecuritiesProvisions getJapaneseSecuritiesProvisions();
	/**
	 * The Jury Waiver conditions specific to the agreement.
	 */
	Boolean getJuryWaiver();
	final static JurisdictionRelatedTermsMeta metaData = new JurisdictionRelatedTermsMeta();
	
	@Override
	default RosettaMetaData<? extends JurisdictionRelatedTerms> metaData() {
		return metaData;
	} 
			
	static JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder builder() {
		return new JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilderImpl();
	}
	
	default Class<? extends JurisdictionRelatedTerms> getType() {
		return JurisdictionRelatedTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("exclusiveJurisdiction"), Boolean.class, getExclusiveJurisdiction(), this);
		processor.processBasic(path.newSubPath("juryWaiver"), Boolean.class, getJuryWaiver(), this);
		
		processRosetta(path.newSubPath("frenchLawAddendum"), processor, FrenchLawAddendum.class, getFrenchLawAddendum());
		processRosetta(path.newSubPath("japaneseSecuritiesProvisions"), processor, JapaneseSecuritiesProvisions.class, getJapaneseSecuritiesProvisions());
	}
	
	
	interface JurisdictionRelatedTermsBuilder extends JurisdictionRelatedTerms, RosettaModelObjectBuilder {
		FrenchLawAddendum.FrenchLawAddendumBuilder getOrCreateFrenchLawAddendum();
		FrenchLawAddendum.FrenchLawAddendumBuilder getFrenchLawAddendum();
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder getOrCreateJapaneseSecuritiesProvisions();
		JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder getJapaneseSecuritiesProvisions();
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setExclusiveJurisdiction(Boolean exclusiveJurisdiction);
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setFrenchLawAddendum(FrenchLawAddendum frenchLawAddendum);
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setJapaneseSecuritiesProvisions(JapaneseSecuritiesProvisions japaneseSecuritiesProvisions);
		JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setJuryWaiver(Boolean juryWaiver);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("exclusiveJurisdiction"), Boolean.class, getExclusiveJurisdiction(), this);
			processor.processBasic(path.newSubPath("juryWaiver"), Boolean.class, getJuryWaiver(), this);
			
			processRosetta(path.newSubPath("frenchLawAddendum"), processor, FrenchLawAddendum.FrenchLawAddendumBuilder.class, getFrenchLawAddendum());
			processRosetta(path.newSubPath("japaneseSecuritiesProvisions"), processor, JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder.class, getJapaneseSecuritiesProvisions());
		}
		
	}
	
	//JurisdictionRelatedTerms.JurisdictionRelatedTermsImpl
	class JurisdictionRelatedTermsImpl implements JurisdictionRelatedTerms {
		private final Boolean exclusiveJurisdiction;
		private final FrenchLawAddendum frenchLawAddendum;
		private final JapaneseSecuritiesProvisions japaneseSecuritiesProvisions;
		private final Boolean juryWaiver;
		
		protected JurisdictionRelatedTermsImpl(JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder builder) {
			this.exclusiveJurisdiction = builder.getExclusiveJurisdiction();
			this.frenchLawAddendum = ofNullable(builder.getFrenchLawAddendum()).map(f->f.build()).orElse(null);
			this.japaneseSecuritiesProvisions = ofNullable(builder.getJapaneseSecuritiesProvisions()).map(f->f.build()).orElse(null);
			this.juryWaiver = builder.getJuryWaiver();
		}
		
		@Override
		public Boolean getExclusiveJurisdiction() {
			return exclusiveJurisdiction;
		}
		
		@Override
		public FrenchLawAddendum getFrenchLawAddendum() {
			return frenchLawAddendum;
		}
		
		@Override
		public JapaneseSecuritiesProvisions getJapaneseSecuritiesProvisions() {
			return japaneseSecuritiesProvisions;
		}
		
		@Override
		public Boolean getJuryWaiver() {
			return juryWaiver;
		}
		
		@Override
		public JurisdictionRelatedTerms build() {
			return this;
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder toBuilder() {
			JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder builder) {
			ofNullable(getExclusiveJurisdiction()).ifPresent(builder::setExclusiveJurisdiction);
			ofNullable(getFrenchLawAddendum()).ifPresent(builder::setFrenchLawAddendum);
			ofNullable(getJapaneseSecuritiesProvisions()).ifPresent(builder::setJapaneseSecuritiesProvisions);
			ofNullable(getJuryWaiver()).ifPresent(builder::setJuryWaiver);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JurisdictionRelatedTerms _that = getType().cast(o);
		
			if (!Objects.equals(exclusiveJurisdiction, _that.getExclusiveJurisdiction())) return false;
			if (!Objects.equals(frenchLawAddendum, _that.getFrenchLawAddendum())) return false;
			if (!Objects.equals(japaneseSecuritiesProvisions, _that.getJapaneseSecuritiesProvisions())) return false;
			if (!Objects.equals(juryWaiver, _that.getJuryWaiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exclusiveJurisdiction != null ? exclusiveJurisdiction.hashCode() : 0);
			_result = 31 * _result + (frenchLawAddendum != null ? frenchLawAddendum.hashCode() : 0);
			_result = 31 * _result + (japaneseSecuritiesProvisions != null ? japaneseSecuritiesProvisions.hashCode() : 0);
			_result = 31 * _result + (juryWaiver != null ? juryWaiver.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JurisdictionRelatedTerms {" +
				"exclusiveJurisdiction=" + this.exclusiveJurisdiction + ", " +
				"frenchLawAddendum=" + this.frenchLawAddendum + ", " +
				"japaneseSecuritiesProvisions=" + this.japaneseSecuritiesProvisions + ", " +
				"juryWaiver=" + this.juryWaiver +
			'}';
		}
	}
	
	//JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilderImpl
	class JurisdictionRelatedTermsBuilderImpl implements JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder {
	
		protected Boolean exclusiveJurisdiction;
		protected FrenchLawAddendum.FrenchLawAddendumBuilder frenchLawAddendum;
		protected JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder japaneseSecuritiesProvisions;
		protected Boolean juryWaiver;
	
		public JurisdictionRelatedTermsBuilderImpl() {
		}
	
		@Override
		public Boolean getExclusiveJurisdiction() {
			return exclusiveJurisdiction;
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder getFrenchLawAddendum() {
			return frenchLawAddendum;
		}
		
		@Override
		public FrenchLawAddendum.FrenchLawAddendumBuilder getOrCreateFrenchLawAddendum() {
			FrenchLawAddendum.FrenchLawAddendumBuilder result;
			if (frenchLawAddendum!=null) {
				result = frenchLawAddendum;
			}
			else {
				result = frenchLawAddendum = FrenchLawAddendum.builder();
			}
			
			return result;
		}
		
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder getJapaneseSecuritiesProvisions() {
			return japaneseSecuritiesProvisions;
		}
		
		@Override
		public JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder getOrCreateJapaneseSecuritiesProvisions() {
			JapaneseSecuritiesProvisions.JapaneseSecuritiesProvisionsBuilder result;
			if (japaneseSecuritiesProvisions!=null) {
				result = japaneseSecuritiesProvisions;
			}
			else {
				result = japaneseSecuritiesProvisions = JapaneseSecuritiesProvisions.builder();
			}
			
			return result;
		}
		
		@Override
		public Boolean getJuryWaiver() {
			return juryWaiver;
		}
		
	
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setExclusiveJurisdiction(Boolean exclusiveJurisdiction) {
			this.exclusiveJurisdiction = exclusiveJurisdiction==null?null:exclusiveJurisdiction;
			return this;
		}
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setFrenchLawAddendum(FrenchLawAddendum frenchLawAddendum) {
			this.frenchLawAddendum = frenchLawAddendum==null?null:frenchLawAddendum.toBuilder();
			return this;
		}
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setJapaneseSecuritiesProvisions(JapaneseSecuritiesProvisions japaneseSecuritiesProvisions) {
			this.japaneseSecuritiesProvisions = japaneseSecuritiesProvisions==null?null:japaneseSecuritiesProvisions.toBuilder();
			return this;
		}
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder setJuryWaiver(Boolean juryWaiver) {
			this.juryWaiver = juryWaiver==null?null:juryWaiver;
			return this;
		}
		
		@Override
		public JurisdictionRelatedTerms build() {
			return new JurisdictionRelatedTerms.JurisdictionRelatedTermsImpl(this);
		}
		
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder prune() {
			if (frenchLawAddendum!=null && !frenchLawAddendum.prune().hasData()) frenchLawAddendum = null;
			if (japaneseSecuritiesProvisions!=null && !japaneseSecuritiesProvisions.prune().hasData()) japaneseSecuritiesProvisions = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExclusiveJurisdiction()!=null) return true;
			if (getFrenchLawAddendum()!=null && getFrenchLawAddendum().hasData()) return true;
			if (getJapaneseSecuritiesProvisions()!=null && getJapaneseSecuritiesProvisions().hasData()) return true;
			if (getJuryWaiver()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder o = (JurisdictionRelatedTerms.JurisdictionRelatedTermsBuilder) other;
			
			merger.mergeRosetta(getFrenchLawAddendum(), o.getFrenchLawAddendum(), this::setFrenchLawAddendum);
			merger.mergeRosetta(getJapaneseSecuritiesProvisions(), o.getJapaneseSecuritiesProvisions(), this::setJapaneseSecuritiesProvisions);
			
			merger.mergeBasic(getExclusiveJurisdiction(), o.getExclusiveJurisdiction(), this::setExclusiveJurisdiction);
			merger.mergeBasic(getJuryWaiver(), o.getJuryWaiver(), this::setJuryWaiver);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			JurisdictionRelatedTerms _that = getType().cast(o);
		
			if (!Objects.equals(exclusiveJurisdiction, _that.getExclusiveJurisdiction())) return false;
			if (!Objects.equals(frenchLawAddendum, _that.getFrenchLawAddendum())) return false;
			if (!Objects.equals(japaneseSecuritiesProvisions, _that.getJapaneseSecuritiesProvisions())) return false;
			if (!Objects.equals(juryWaiver, _that.getJuryWaiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exclusiveJurisdiction != null ? exclusiveJurisdiction.hashCode() : 0);
			_result = 31 * _result + (frenchLawAddendum != null ? frenchLawAddendum.hashCode() : 0);
			_result = 31 * _result + (japaneseSecuritiesProvisions != null ? japaneseSecuritiesProvisions.hashCode() : 0);
			_result = 31 * _result + (juryWaiver != null ? juryWaiver.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "JurisdictionRelatedTermsBuilder {" +
				"exclusiveJurisdiction=" + this.exclusiveJurisdiction + ", " +
				"frenchLawAddendum=" + this.frenchLawAddendum + ", " +
				"japaneseSecuritiesProvisions=" + this.japaneseSecuritiesProvisions + ", " +
				"juryWaiver=" + this.juryWaiver +
			'}';
		}
	}
}
