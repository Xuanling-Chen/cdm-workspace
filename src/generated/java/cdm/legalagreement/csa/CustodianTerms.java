package cdm.legalagreement.csa;

import cdm.base.staticdata.party.LegalEntity;
import cdm.legalagreement.csa.meta.CustodianTermsMeta;
import cdm.observable.asset.CreditNotation;
import cdm.observable.asset.Money;
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
 * A class to specify the requirements applicable to the custodian with respect to the holding of posted collateral. ISDA 2016 Credit Support Annex for Variation Margin, paragraph 13, (h)(i): Eligibility to Hold Posted Collateral (VM) Custodians (VM).
 * @version ${project.version}
 */
@RosettaClass

public interface CustodianTerms extends RosettaModelObject {
	CustodianTerms build();
	CustodianTerms.CustodianTermsBuilder toBuilder();
	
	/**
	 * The 2016 ISDA CSA for Variation Margin provides the ability for the parties to specify the initial custodian.
	 */
	LegalEntity getInitialDesignation();
	/**
	 * The minimal level of assets requirement with respect to the custody agent.
	 */
	Money getMinimumAssets();
	/**
	 * The minimal rating requirement with respect to the custody agent.
	 */
	CreditNotation getMinimumRating();
	final static CustodianTermsMeta metaData = new CustodianTermsMeta();
	
	@Override
	default RosettaMetaData<? extends CustodianTerms> metaData() {
		return metaData;
	} 
			
	static CustodianTerms.CustodianTermsBuilder builder() {
		return new CustodianTerms.CustodianTermsBuilderImpl();
	}
	
	default Class<? extends CustodianTerms> getType() {
		return CustodianTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("initialDesignation"), processor, LegalEntity.class, getInitialDesignation());
		processRosetta(path.newSubPath("minimumAssets"), processor, Money.class, getMinimumAssets());
		processRosetta(path.newSubPath("minimumRating"), processor, CreditNotation.class, getMinimumRating());
	}
	
	
	interface CustodianTermsBuilder extends CustodianTerms, RosettaModelObjectBuilder {
		LegalEntity.LegalEntityBuilder getOrCreateInitialDesignation();
		LegalEntity.LegalEntityBuilder getInitialDesignation();
		Money.MoneyBuilder getOrCreateMinimumAssets();
		Money.MoneyBuilder getMinimumAssets();
		CreditNotation.CreditNotationBuilder getOrCreateMinimumRating();
		CreditNotation.CreditNotationBuilder getMinimumRating();
		CustodianTerms.CustodianTermsBuilder setInitialDesignation(LegalEntity initialDesignation);
		CustodianTerms.CustodianTermsBuilder setMinimumAssets(Money minimumAssets);
		CustodianTerms.CustodianTermsBuilder setMinimumRating(CreditNotation minimumRating);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("initialDesignation"), processor, LegalEntity.LegalEntityBuilder.class, getInitialDesignation());
			processRosetta(path.newSubPath("minimumAssets"), processor, Money.MoneyBuilder.class, getMinimumAssets());
			processRosetta(path.newSubPath("minimumRating"), processor, CreditNotation.CreditNotationBuilder.class, getMinimumRating());
		}
		
	}
	
	//CustodianTerms.CustodianTermsImpl
	class CustodianTermsImpl implements CustodianTerms {
		private final LegalEntity initialDesignation;
		private final Money minimumAssets;
		private final CreditNotation minimumRating;
		
		protected CustodianTermsImpl(CustodianTerms.CustodianTermsBuilder builder) {
			this.initialDesignation = ofNullable(builder.getInitialDesignation()).map(f->f.build()).orElse(null);
			this.minimumAssets = ofNullable(builder.getMinimumAssets()).map(f->f.build()).orElse(null);
			this.minimumRating = ofNullable(builder.getMinimumRating()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public LegalEntity getInitialDesignation() {
			return initialDesignation;
		}
		
		@Override
		public Money getMinimumAssets() {
			return minimumAssets;
		}
		
		@Override
		public CreditNotation getMinimumRating() {
			return minimumRating;
		}
		
		@Override
		public CustodianTerms build() {
			return this;
		}
		
		@Override
		public CustodianTerms.CustodianTermsBuilder toBuilder() {
			CustodianTerms.CustodianTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CustodianTerms.CustodianTermsBuilder builder) {
			ofNullable(getInitialDesignation()).ifPresent(builder::setInitialDesignation);
			ofNullable(getMinimumAssets()).ifPresent(builder::setMinimumAssets);
			ofNullable(getMinimumRating()).ifPresent(builder::setMinimumRating);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianTerms _that = getType().cast(o);
		
			if (!Objects.equals(initialDesignation, _that.getInitialDesignation())) return false;
			if (!Objects.equals(minimumAssets, _that.getMinimumAssets())) return false;
			if (!Objects.equals(minimumRating, _that.getMinimumRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialDesignation != null ? initialDesignation.hashCode() : 0);
			_result = 31 * _result + (minimumAssets != null ? minimumAssets.hashCode() : 0);
			_result = 31 * _result + (minimumRating != null ? minimumRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianTerms {" +
				"initialDesignation=" + this.initialDesignation + ", " +
				"minimumAssets=" + this.minimumAssets + ", " +
				"minimumRating=" + this.minimumRating +
			'}';
		}
	}
	
	//CustodianTerms.CustodianTermsBuilderImpl
	class CustodianTermsBuilderImpl implements CustodianTerms.CustodianTermsBuilder {
	
		protected LegalEntity.LegalEntityBuilder initialDesignation;
		protected Money.MoneyBuilder minimumAssets;
		protected CreditNotation.CreditNotationBuilder minimumRating;
	
		public CustodianTermsBuilderImpl() {
		}
	
		@Override
		public LegalEntity.LegalEntityBuilder getInitialDesignation() {
			return initialDesignation;
		}
		
		@Override
		public LegalEntity.LegalEntityBuilder getOrCreateInitialDesignation() {
			LegalEntity.LegalEntityBuilder result;
			if (initialDesignation!=null) {
				result = initialDesignation;
			}
			else {
				result = initialDesignation = LegalEntity.builder();
			}
			
			return result;
		}
		
		@Override
		public Money.MoneyBuilder getMinimumAssets() {
			return minimumAssets;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateMinimumAssets() {
			Money.MoneyBuilder result;
			if (minimumAssets!=null) {
				result = minimumAssets;
			}
			else {
				result = minimumAssets = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditNotation.CreditNotationBuilder getMinimumRating() {
			return minimumRating;
		}
		
		@Override
		public CreditNotation.CreditNotationBuilder getOrCreateMinimumRating() {
			CreditNotation.CreditNotationBuilder result;
			if (minimumRating!=null) {
				result = minimumRating;
			}
			else {
				result = minimumRating = CreditNotation.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CustodianTerms.CustodianTermsBuilder setInitialDesignation(LegalEntity initialDesignation) {
			this.initialDesignation = initialDesignation==null?null:initialDesignation.toBuilder();
			return this;
		}
		@Override
		public CustodianTerms.CustodianTermsBuilder setMinimumAssets(Money minimumAssets) {
			this.minimumAssets = minimumAssets==null?null:minimumAssets.toBuilder();
			return this;
		}
		@Override
		public CustodianTerms.CustodianTermsBuilder setMinimumRating(CreditNotation minimumRating) {
			this.minimumRating = minimumRating==null?null:minimumRating.toBuilder();
			return this;
		}
		
		@Override
		public CustodianTerms build() {
			return new CustodianTerms.CustodianTermsImpl(this);
		}
		
		@Override
		public CustodianTerms.CustodianTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianTerms.CustodianTermsBuilder prune() {
			if (initialDesignation!=null && !initialDesignation.prune().hasData()) initialDesignation = null;
			if (minimumAssets!=null && !minimumAssets.prune().hasData()) minimumAssets = null;
			if (minimumRating!=null && !minimumRating.prune().hasData()) minimumRating = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialDesignation()!=null && getInitialDesignation().hasData()) return true;
			if (getMinimumAssets()!=null && getMinimumAssets().hasData()) return true;
			if (getMinimumRating()!=null && getMinimumRating().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CustodianTerms.CustodianTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CustodianTerms.CustodianTermsBuilder o = (CustodianTerms.CustodianTermsBuilder) other;
			
			merger.mergeRosetta(getInitialDesignation(), o.getInitialDesignation(), this::setInitialDesignation);
			merger.mergeRosetta(getMinimumAssets(), o.getMinimumAssets(), this::setMinimumAssets);
			merger.mergeRosetta(getMinimumRating(), o.getMinimumRating(), this::setMinimumRating);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CustodianTerms _that = getType().cast(o);
		
			if (!Objects.equals(initialDesignation, _that.getInitialDesignation())) return false;
			if (!Objects.equals(minimumAssets, _that.getMinimumAssets())) return false;
			if (!Objects.equals(minimumRating, _that.getMinimumRating())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialDesignation != null ? initialDesignation.hashCode() : 0);
			_result = 31 * _result + (minimumAssets != null ? minimumAssets.hashCode() : 0);
			_result = 31 * _result + (minimumRating != null ? minimumRating.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CustodianTermsBuilder {" +
				"initialDesignation=" + this.initialDesignation + ", " +
				"minimumAssets=" + this.minimumAssets + ", " +
				"minimumRating=" + this.minimumRating +
			'}';
		}
	}
}
