package cdm.legalagreement.csa;

import cdm.legalagreement.common.OtherAgreementTerms;
import cdm.legalagreement.csa.meta.OtherAgreementsMeta;
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
 * The bespoke definition of other agreement terms as specified by the parties to the agreement.
 * @version ${project.version}
 */
@RosettaClass

public interface OtherAgreements extends RosettaModelObject {
	OtherAgreements build();
	OtherAgreements.OtherAgreementsBuilder toBuilder();
	
	/**
	 * The bespoke definition of whether Japanese Law CSA (VM) are specified by the parties to the agreement. ISDA 2016 Credit Support Annex for Initial Margin, paragraph 13, General Principles, (s)(ii): Japanese Law CSA (VM).
	 */
	OtherAgreementTerms getJapaneseLawCsa();
	/**
	 * The bespoke definition of Other CSA as specified by the parties to the agreement.
	 */
	OtherAgreementTerms getOtherCsa();
	final static OtherAgreementsMeta metaData = new OtherAgreementsMeta();
	
	@Override
	default RosettaMetaData<? extends OtherAgreements> metaData() {
		return metaData;
	} 
			
	static OtherAgreements.OtherAgreementsBuilder builder() {
		return new OtherAgreements.OtherAgreementsBuilderImpl();
	}
	
	default Class<? extends OtherAgreements> getType() {
		return OtherAgreements.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("japaneseLawCsa"), processor, OtherAgreementTerms.class, getJapaneseLawCsa());
		processRosetta(path.newSubPath("otherCsa"), processor, OtherAgreementTerms.class, getOtherCsa());
	}
	
	
	interface OtherAgreementsBuilder extends OtherAgreements, RosettaModelObjectBuilder {
		OtherAgreementTerms.OtherAgreementTermsBuilder getOrCreateJapaneseLawCsa();
		OtherAgreementTerms.OtherAgreementTermsBuilder getJapaneseLawCsa();
		OtherAgreementTerms.OtherAgreementTermsBuilder getOrCreateOtherCsa();
		OtherAgreementTerms.OtherAgreementTermsBuilder getOtherCsa();
		OtherAgreements.OtherAgreementsBuilder setJapaneseLawCsa(OtherAgreementTerms japaneseLawCsa);
		OtherAgreements.OtherAgreementsBuilder setOtherCsa(OtherAgreementTerms otherCsa);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("japaneseLawCsa"), processor, OtherAgreementTerms.OtherAgreementTermsBuilder.class, getJapaneseLawCsa());
			processRosetta(path.newSubPath("otherCsa"), processor, OtherAgreementTerms.OtherAgreementTermsBuilder.class, getOtherCsa());
		}
		
	}
	
	//OtherAgreements.OtherAgreementsImpl
	class OtherAgreementsImpl implements OtherAgreements {
		private final OtherAgreementTerms japaneseLawCsa;
		private final OtherAgreementTerms otherCsa;
		
		protected OtherAgreementsImpl(OtherAgreements.OtherAgreementsBuilder builder) {
			this.japaneseLawCsa = ofNullable(builder.getJapaneseLawCsa()).map(f->f.build()).orElse(null);
			this.otherCsa = ofNullable(builder.getOtherCsa()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public OtherAgreementTerms getJapaneseLawCsa() {
			return japaneseLawCsa;
		}
		
		@Override
		public OtherAgreementTerms getOtherCsa() {
			return otherCsa;
		}
		
		@Override
		public OtherAgreements build() {
			return this;
		}
		
		@Override
		public OtherAgreements.OtherAgreementsBuilder toBuilder() {
			OtherAgreements.OtherAgreementsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OtherAgreements.OtherAgreementsBuilder builder) {
			ofNullable(getJapaneseLawCsa()).ifPresent(builder::setJapaneseLawCsa);
			ofNullable(getOtherCsa()).ifPresent(builder::setOtherCsa);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreements _that = getType().cast(o);
		
			if (!Objects.equals(japaneseLawCsa, _that.getJapaneseLawCsa())) return false;
			if (!Objects.equals(otherCsa, _that.getOtherCsa())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (japaneseLawCsa != null ? japaneseLawCsa.hashCode() : 0);
			_result = 31 * _result + (otherCsa != null ? otherCsa.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreements {" +
				"japaneseLawCsa=" + this.japaneseLawCsa + ", " +
				"otherCsa=" + this.otherCsa +
			'}';
		}
	}
	
	//OtherAgreements.OtherAgreementsBuilderImpl
	class OtherAgreementsBuilderImpl implements OtherAgreements.OtherAgreementsBuilder {
	
		protected OtherAgreementTerms.OtherAgreementTermsBuilder japaneseLawCsa;
		protected OtherAgreementTerms.OtherAgreementTermsBuilder otherCsa;
	
		public OtherAgreementsBuilderImpl() {
		}
	
		@Override
		public OtherAgreementTerms.OtherAgreementTermsBuilder getJapaneseLawCsa() {
			return japaneseLawCsa;
		}
		
		@Override
		public OtherAgreementTerms.OtherAgreementTermsBuilder getOrCreateJapaneseLawCsa() {
			OtherAgreementTerms.OtherAgreementTermsBuilder result;
			if (japaneseLawCsa!=null) {
				result = japaneseLawCsa;
			}
			else {
				result = japaneseLawCsa = OtherAgreementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public OtherAgreementTerms.OtherAgreementTermsBuilder getOtherCsa() {
			return otherCsa;
		}
		
		@Override
		public OtherAgreementTerms.OtherAgreementTermsBuilder getOrCreateOtherCsa() {
			OtherAgreementTerms.OtherAgreementTermsBuilder result;
			if (otherCsa!=null) {
				result = otherCsa;
			}
			else {
				result = otherCsa = OtherAgreementTerms.builder();
			}
			
			return result;
		}
		
	
		@Override
		public OtherAgreements.OtherAgreementsBuilder setJapaneseLawCsa(OtherAgreementTerms japaneseLawCsa) {
			this.japaneseLawCsa = japaneseLawCsa==null?null:japaneseLawCsa.toBuilder();
			return this;
		}
		@Override
		public OtherAgreements.OtherAgreementsBuilder setOtherCsa(OtherAgreementTerms otherCsa) {
			this.otherCsa = otherCsa==null?null:otherCsa.toBuilder();
			return this;
		}
		
		@Override
		public OtherAgreements build() {
			return new OtherAgreements.OtherAgreementsImpl(this);
		}
		
		@Override
		public OtherAgreements.OtherAgreementsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreements.OtherAgreementsBuilder prune() {
			if (japaneseLawCsa!=null && !japaneseLawCsa.prune().hasData()) japaneseLawCsa = null;
			if (otherCsa!=null && !otherCsa.prune().hasData()) otherCsa = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getJapaneseLawCsa()!=null && getJapaneseLawCsa().hasData()) return true;
			if (getOtherCsa()!=null && getOtherCsa().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OtherAgreements.OtherAgreementsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OtherAgreements.OtherAgreementsBuilder o = (OtherAgreements.OtherAgreementsBuilder) other;
			
			merger.mergeRosetta(getJapaneseLawCsa(), o.getJapaneseLawCsa(), this::setJapaneseLawCsa);
			merger.mergeRosetta(getOtherCsa(), o.getOtherCsa(), this::setOtherCsa);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OtherAgreements _that = getType().cast(o);
		
			if (!Objects.equals(japaneseLawCsa, _that.getJapaneseLawCsa())) return false;
			if (!Objects.equals(otherCsa, _that.getOtherCsa())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (japaneseLawCsa != null ? japaneseLawCsa.hashCode() : 0);
			_result = 31 * _result + (otherCsa != null ? otherCsa.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OtherAgreementsBuilder {" +
				"japaneseLawCsa=" + this.japaneseLawCsa + ", " +
				"otherCsa=" + this.otherCsa +
			'}';
		}
	}
}
