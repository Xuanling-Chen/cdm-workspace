package cdm.observable.asset;

import cdm.observable.asset.meta.CreditNotationMeta;
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
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A class to specify the credit notation as the combination of agency, notation, scale and debt type qualifications.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditNotation extends RosettaModelObject {
	CreditNotation build();
	CreditNotation.CreditNotationBuilder toBuilder();
	
	/**
	 * The credit agency to which the other variables (notation, scale, debt type) refer to.
	 */
	CreditRatingAgencyEnum getAgency();
	/**
	 * Regarding the potential direction of a short-term or long-term rating. It focuses on identifiable events and short-term trends that cause ratings to be placed under special surveillance.
	 */
	CreditRatingCreditWatchEnum getCreditWatch();
	/**
	 * The credit rating debt type (e.g. long term, high yield, deposits, ...) associated with the credit rating notation and scale.
	 */
	CreditRatingDebt getDebt();
	/**
	 * The credit rating notation. As it varies among credit rating agencies, FpML doesn&#39;t specify a default scheme.
	 */
	FieldWithMetaString getNotation();
	/**
	 * Assesses the potential direction of a long-term credit rating over the intermediate term, which is generally up to two years for investment grade and generally up to one year for speculative grade.
	 */
	CreditRatingOutlookEnum getOutlook();
	/**
	 * The credit rating scale, with a typical distinction between short term, long term. FpML doesn&#39;t specify a default scheme, which is hence not specified as an enumeration as part of the CDM.
	 */
	FieldWithMetaString getScale();
	final static CreditNotationMeta metaData = new CreditNotationMeta();
	
	@Override
	default RosettaMetaData<? extends CreditNotation> metaData() {
		return metaData;
	} 
			
	static CreditNotation.CreditNotationBuilder builder() {
		return new CreditNotation.CreditNotationBuilderImpl();
	}
	
	default Class<? extends CreditNotation> getType() {
		return CreditNotation.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("agency"), CreditRatingAgencyEnum.class, getAgency(), this);
		processor.processBasic(path.newSubPath("creditWatch"), CreditRatingCreditWatchEnum.class, getCreditWatch(), this);
		processor.processBasic(path.newSubPath("outlook"), CreditRatingOutlookEnum.class, getOutlook(), this);
		
		processRosetta(path.newSubPath("debt"), processor, CreditRatingDebt.class, getDebt());
		processRosetta(path.newSubPath("notation"), processor, FieldWithMetaString.class, getNotation());
		processRosetta(path.newSubPath("scale"), processor, FieldWithMetaString.class, getScale());
	}
	
	
	interface CreditNotationBuilder extends CreditNotation, RosettaModelObjectBuilder {
		CreditRatingDebt.CreditRatingDebtBuilder getOrCreateDebt();
		CreditRatingDebt.CreditRatingDebtBuilder getDebt();
		FieldWithMetaStringBuilder getOrCreateNotation();
		FieldWithMetaStringBuilder getNotation();
		FieldWithMetaStringBuilder getOrCreateScale();
		FieldWithMetaStringBuilder getScale();
		CreditNotation.CreditNotationBuilder setAgency(CreditRatingAgencyEnum agency);
		CreditNotation.CreditNotationBuilder setCreditWatch(CreditRatingCreditWatchEnum creditWatch);
		CreditNotation.CreditNotationBuilder setDebt(CreditRatingDebt debt);
		CreditNotation.CreditNotationBuilder setNotation(FieldWithMetaString notation);
		CreditNotation.CreditNotationBuilder setNotationValue(String notation);
		CreditNotation.CreditNotationBuilder setOutlook(CreditRatingOutlookEnum outlook);
		CreditNotation.CreditNotationBuilder setScale(FieldWithMetaString scale);
		CreditNotation.CreditNotationBuilder setScaleValue(String scale);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("agency"), CreditRatingAgencyEnum.class, getAgency(), this);
			processor.processBasic(path.newSubPath("creditWatch"), CreditRatingCreditWatchEnum.class, getCreditWatch(), this);
			processor.processBasic(path.newSubPath("outlook"), CreditRatingOutlookEnum.class, getOutlook(), this);
			
			processRosetta(path.newSubPath("debt"), processor, CreditRatingDebt.CreditRatingDebtBuilder.class, getDebt());
			processRosetta(path.newSubPath("notation"), processor, FieldWithMetaStringBuilder.class, getNotation());
			processRosetta(path.newSubPath("scale"), processor, FieldWithMetaStringBuilder.class, getScale());
		}
		
	}
	
	//CreditNotation.CreditNotationImpl
	class CreditNotationImpl implements CreditNotation {
		private final CreditRatingAgencyEnum agency;
		private final CreditRatingCreditWatchEnum creditWatch;
		private final CreditRatingDebt debt;
		private final FieldWithMetaString notation;
		private final CreditRatingOutlookEnum outlook;
		private final FieldWithMetaString scale;
		
		protected CreditNotationImpl(CreditNotation.CreditNotationBuilder builder) {
			this.agency = builder.getAgency();
			this.creditWatch = builder.getCreditWatch();
			this.debt = ofNullable(builder.getDebt()).map(f->f.build()).orElse(null);
			this.notation = ofNullable(builder.getNotation()).map(f->f.build()).orElse(null);
			this.outlook = builder.getOutlook();
			this.scale = ofNullable(builder.getScale()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public CreditRatingAgencyEnum getAgency() {
			return agency;
		}
		
		@Override
		public CreditRatingCreditWatchEnum getCreditWatch() {
			return creditWatch;
		}
		
		@Override
		public CreditRatingDebt getDebt() {
			return debt;
		}
		
		@Override
		public FieldWithMetaString getNotation() {
			return notation;
		}
		
		@Override
		public CreditRatingOutlookEnum getOutlook() {
			return outlook;
		}
		
		@Override
		public FieldWithMetaString getScale() {
			return scale;
		}
		
		@Override
		public CreditNotation build() {
			return this;
		}
		
		@Override
		public CreditNotation.CreditNotationBuilder toBuilder() {
			CreditNotation.CreditNotationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditNotation.CreditNotationBuilder builder) {
			ofNullable(getAgency()).ifPresent(builder::setAgency);
			ofNullable(getCreditWatch()).ifPresent(builder::setCreditWatch);
			ofNullable(getDebt()).ifPresent(builder::setDebt);
			ofNullable(getNotation()).ifPresent(builder::setNotation);
			ofNullable(getOutlook()).ifPresent(builder::setOutlook);
			ofNullable(getScale()).ifPresent(builder::setScale);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditNotation _that = getType().cast(o);
		
			if (!Objects.equals(agency, _that.getAgency())) return false;
			if (!Objects.equals(creditWatch, _that.getCreditWatch())) return false;
			if (!Objects.equals(debt, _that.getDebt())) return false;
			if (!Objects.equals(notation, _that.getNotation())) return false;
			if (!Objects.equals(outlook, _that.getOutlook())) return false;
			if (!Objects.equals(scale, _that.getScale())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agency != null ? agency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditWatch != null ? creditWatch.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debt != null ? debt.hashCode() : 0);
			_result = 31 * _result + (notation != null ? notation.hashCode() : 0);
			_result = 31 * _result + (outlook != null ? outlook.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (scale != null ? scale.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditNotation {" +
				"agency=" + this.agency + ", " +
				"creditWatch=" + this.creditWatch + ", " +
				"debt=" + this.debt + ", " +
				"notation=" + this.notation + ", " +
				"outlook=" + this.outlook + ", " +
				"scale=" + this.scale +
			'}';
		}
	}
	
	//CreditNotation.CreditNotationBuilderImpl
	class CreditNotationBuilderImpl implements CreditNotation.CreditNotationBuilder {
	
		protected CreditRatingAgencyEnum agency;
		protected CreditRatingCreditWatchEnum creditWatch;
		protected CreditRatingDebt.CreditRatingDebtBuilder debt;
		protected FieldWithMetaStringBuilder notation;
		protected CreditRatingOutlookEnum outlook;
		protected FieldWithMetaStringBuilder scale;
	
		public CreditNotationBuilderImpl() {
		}
	
		@Override
		public CreditRatingAgencyEnum getAgency() {
			return agency;
		}
		
		@Override
		public CreditRatingCreditWatchEnum getCreditWatch() {
			return creditWatch;
		}
		
		@Override
		public CreditRatingDebt.CreditRatingDebtBuilder getDebt() {
			return debt;
		}
		
		@Override
		public CreditRatingDebt.CreditRatingDebtBuilder getOrCreateDebt() {
			CreditRatingDebt.CreditRatingDebtBuilder result;
			if (debt!=null) {
				result = debt;
			}
			else {
				result = debt = CreditRatingDebt.builder();
			}
			
			return result;
		}
		
		@Override
		public FieldWithMetaStringBuilder getNotation() {
			return notation;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateNotation() {
			FieldWithMetaStringBuilder result;
			if (notation!=null) {
				result = notation;
			}
			else {
				result = notation = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public CreditRatingOutlookEnum getOutlook() {
			return outlook;
		}
		
		@Override
		public FieldWithMetaStringBuilder getScale() {
			return scale;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateScale() {
			FieldWithMetaStringBuilder result;
			if (scale!=null) {
				result = scale;
			}
			else {
				result = scale = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CreditNotation.CreditNotationBuilder setAgency(CreditRatingAgencyEnum agency) {
			this.agency = agency==null?null:agency;
			return this;
		}
		@Override
		public CreditNotation.CreditNotationBuilder setCreditWatch(CreditRatingCreditWatchEnum creditWatch) {
			this.creditWatch = creditWatch==null?null:creditWatch;
			return this;
		}
		@Override
		public CreditNotation.CreditNotationBuilder setDebt(CreditRatingDebt debt) {
			this.debt = debt==null?null:debt.toBuilder();
			return this;
		}
		@Override
		public CreditNotation.CreditNotationBuilder setNotation(FieldWithMetaString notation) {
			this.notation = notation==null?null:notation.toBuilder();
			return this;
		}
		
		@Override
		public CreditNotation.CreditNotationBuilder setNotationValue(String notation) {
			this.getOrCreateNotation().setValue(notation);
			return this;
		}
		@Override
		public CreditNotation.CreditNotationBuilder setOutlook(CreditRatingOutlookEnum outlook) {
			this.outlook = outlook==null?null:outlook;
			return this;
		}
		@Override
		public CreditNotation.CreditNotationBuilder setScale(FieldWithMetaString scale) {
			this.scale = scale==null?null:scale.toBuilder();
			return this;
		}
		
		@Override
		public CreditNotation.CreditNotationBuilder setScaleValue(String scale) {
			this.getOrCreateScale().setValue(scale);
			return this;
		}
		
		@Override
		public CreditNotation build() {
			return new CreditNotation.CreditNotationImpl(this);
		}
		
		@Override
		public CreditNotation.CreditNotationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditNotation.CreditNotationBuilder prune() {
			if (debt!=null && !debt.prune().hasData()) debt = null;
			if (notation!=null && !notation.prune().hasData()) notation = null;
			if (scale!=null && !scale.prune().hasData()) scale = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAgency()!=null) return true;
			if (getCreditWatch()!=null) return true;
			if (getDebt()!=null && getDebt().hasData()) return true;
			if (getNotation()!=null) return true;
			if (getOutlook()!=null) return true;
			if (getScale()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditNotation.CreditNotationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditNotation.CreditNotationBuilder o = (CreditNotation.CreditNotationBuilder) other;
			
			merger.mergeRosetta(getDebt(), o.getDebt(), this::setDebt);
			merger.mergeRosetta(getNotation(), o.getNotation(), this::setNotation);
			merger.mergeRosetta(getScale(), o.getScale(), this::setScale);
			
			merger.mergeBasic(getAgency(), o.getAgency(), this::setAgency);
			merger.mergeBasic(getCreditWatch(), o.getCreditWatch(), this::setCreditWatch);
			merger.mergeBasic(getOutlook(), o.getOutlook(), this::setOutlook);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditNotation _that = getType().cast(o);
		
			if (!Objects.equals(agency, _that.getAgency())) return false;
			if (!Objects.equals(creditWatch, _that.getCreditWatch())) return false;
			if (!Objects.equals(debt, _that.getDebt())) return false;
			if (!Objects.equals(notation, _that.getNotation())) return false;
			if (!Objects.equals(outlook, _that.getOutlook())) return false;
			if (!Objects.equals(scale, _that.getScale())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (agency != null ? agency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (creditWatch != null ? creditWatch.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debt != null ? debt.hashCode() : 0);
			_result = 31 * _result + (notation != null ? notation.hashCode() : 0);
			_result = 31 * _result + (outlook != null ? outlook.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (scale != null ? scale.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditNotationBuilder {" +
				"agency=" + this.agency + ", " +
				"creditWatch=" + this.creditWatch + ", " +
				"debt=" + this.debt + ", " +
				"notation=" + this.notation + ", " +
				"outlook=" + this.outlook + ", " +
				"scale=" + this.scale +
			'}';
		}
	}
}
