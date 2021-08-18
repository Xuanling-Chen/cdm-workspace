package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CreditSupportAgreementMeta;
import cdm.legalagreement.csa.metafields.FieldWithMetaCreditSupportAgreementTypeEnum;
import cdm.legalagreement.csa.metafields.FieldWithMetaCreditSupportAgreementTypeEnum.FieldWithMetaCreditSupportAgreementTypeEnumBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The agreement executed between the parties and intended to govern collateral arrangement for all OTC derivatives transactions between those parties.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditSupportAgreement extends RosettaModelObject {
	CreditSupportAgreement build();
	CreditSupportAgreement.CreditSupportAgreementBuilder toBuilder();
	
	/**
	 * The type of ISDA Credit Support Agreement.
	 */
	FieldWithMetaCreditSupportAgreementTypeEnum getCreditSupportAgreementType();
	/**
	 * The date of the agreement executed between the parties and intended to govern collateral arrangements for all OTC derivatives transactions between those parties.
	 */
	Date getDate();
	/**
	 * An identifier used to uniquely identify the CSA. FpML specifies the type as creditSupportAgreementIdScheme, but without proposing any value.  As far as e understand, no scheme has yet been developed at this point.
	 */
	String getIdentifierValue();
	final static CreditSupportAgreementMeta metaData = new CreditSupportAgreementMeta();
	
	@Override
	default RosettaMetaData<? extends CreditSupportAgreement> metaData() {
		return metaData;
	} 
			
	static CreditSupportAgreement.CreditSupportAgreementBuilder builder() {
		return new CreditSupportAgreement.CreditSupportAgreementBuilderImpl();
	}
	
	default Class<? extends CreditSupportAgreement> getType() {
		return CreditSupportAgreement.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("identifierValue"), String.class, getIdentifierValue(), this);
		
		processRosetta(path.newSubPath("creditSupportAgreementType"), processor, FieldWithMetaCreditSupportAgreementTypeEnum.class, getCreditSupportAgreementType());
	}
	
	
	interface CreditSupportAgreementBuilder extends CreditSupportAgreement, RosettaModelObjectBuilder {
		FieldWithMetaCreditSupportAgreementTypeEnumBuilder getOrCreateCreditSupportAgreementType();
		FieldWithMetaCreditSupportAgreementTypeEnumBuilder getCreditSupportAgreementType();
		CreditSupportAgreement.CreditSupportAgreementBuilder setCreditSupportAgreementType(FieldWithMetaCreditSupportAgreementTypeEnum creditSupportAgreementType);
		CreditSupportAgreement.CreditSupportAgreementBuilder setCreditSupportAgreementTypeValue(CreditSupportAgreementTypeEnum creditSupportAgreementType);
		CreditSupportAgreement.CreditSupportAgreementBuilder setDate(Date date);
		CreditSupportAgreement.CreditSupportAgreementBuilder setIdentifierValue(String identifierValue);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("identifierValue"), String.class, getIdentifierValue(), this);
			
			processRosetta(path.newSubPath("creditSupportAgreementType"), processor, FieldWithMetaCreditSupportAgreementTypeEnumBuilder.class, getCreditSupportAgreementType());
		}
		
	}
	
	//CreditSupportAgreement.CreditSupportAgreementImpl
	class CreditSupportAgreementImpl implements CreditSupportAgreement {
		private final FieldWithMetaCreditSupportAgreementTypeEnum creditSupportAgreementType;
		private final Date date;
		private final String identifierValue;
		
		protected CreditSupportAgreementImpl(CreditSupportAgreement.CreditSupportAgreementBuilder builder) {
			this.creditSupportAgreementType = ofNullable(builder.getCreditSupportAgreementType()).map(f->f.build()).orElse(null);
			this.date = builder.getDate();
			this.identifierValue = builder.getIdentifierValue();
		}
		
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnum getCreditSupportAgreementType() {
			return creditSupportAgreementType;
		}
		
		@Override
		public Date getDate() {
			return date;
		}
		
		@Override
		public String getIdentifierValue() {
			return identifierValue;
		}
		
		@Override
		public CreditSupportAgreement build() {
			return this;
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder toBuilder() {
			CreditSupportAgreement.CreditSupportAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportAgreement.CreditSupportAgreementBuilder builder) {
			ofNullable(getCreditSupportAgreementType()).ifPresent(builder::setCreditSupportAgreementType);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getIdentifierValue()).ifPresent(builder::setIdentifierValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreement _that = getType().cast(o);
		
			if (!Objects.equals(creditSupportAgreementType, _that.getCreditSupportAgreementType())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(identifierValue, _that.getIdentifierValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportAgreementType != null ? creditSupportAgreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (identifierValue != null ? identifierValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreement {" +
				"creditSupportAgreementType=" + this.creditSupportAgreementType + ", " +
				"date=" + this.date + ", " +
				"identifierValue=" + this.identifierValue +
			'}';
		}
	}
	
	//CreditSupportAgreement.CreditSupportAgreementBuilderImpl
	class CreditSupportAgreementBuilderImpl implements CreditSupportAgreement.CreditSupportAgreementBuilder {
	
		protected FieldWithMetaCreditSupportAgreementTypeEnumBuilder creditSupportAgreementType;
		protected Date date;
		protected String identifierValue;
	
		public CreditSupportAgreementBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnumBuilder getCreditSupportAgreementType() {
			return creditSupportAgreementType;
		}
		
		@Override
		public FieldWithMetaCreditSupportAgreementTypeEnumBuilder getOrCreateCreditSupportAgreementType() {
			FieldWithMetaCreditSupportAgreementTypeEnumBuilder result;
			if (creditSupportAgreementType!=null) {
				result = creditSupportAgreementType;
			}
			else {
				result = creditSupportAgreementType = FieldWithMetaCreditSupportAgreementTypeEnum.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getDate() {
			return date;
		}
		
		@Override
		public String getIdentifierValue() {
			return identifierValue;
		}
		
	
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder setCreditSupportAgreementType(FieldWithMetaCreditSupportAgreementTypeEnum creditSupportAgreementType) {
			this.creditSupportAgreementType = creditSupportAgreementType==null?null:creditSupportAgreementType.toBuilder();
			return this;
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder setCreditSupportAgreementTypeValue(CreditSupportAgreementTypeEnum creditSupportAgreementType) {
			this.getOrCreateCreditSupportAgreementType().setValue(creditSupportAgreementType);
			return this;
		}
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder setIdentifierValue(String identifierValue) {
			this.identifierValue = identifierValue==null?null:identifierValue;
			return this;
		}
		
		@Override
		public CreditSupportAgreement build() {
			return new CreditSupportAgreement.CreditSupportAgreementImpl(this);
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder prune() {
			if (creditSupportAgreementType!=null && !creditSupportAgreementType.prune().hasData()) creditSupportAgreementType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCreditSupportAgreementType()!=null) return true;
			if (getDate()!=null) return true;
			if (getIdentifierValue()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportAgreement.CreditSupportAgreementBuilder o = (CreditSupportAgreement.CreditSupportAgreementBuilder) other;
			
			merger.mergeRosetta(getCreditSupportAgreementType(), o.getCreditSupportAgreementType(), this::setCreditSupportAgreementType);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getIdentifierValue(), o.getIdentifierValue(), this::setIdentifierValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreement _that = getType().cast(o);
		
			if (!Objects.equals(creditSupportAgreementType, _that.getCreditSupportAgreementType())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(identifierValue, _that.getIdentifierValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (creditSupportAgreementType != null ? creditSupportAgreementType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (identifierValue != null ? identifierValue.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementBuilder {" +
				"creditSupportAgreementType=" + this.creditSupportAgreementType + ", " +
				"date=" + this.date + ", " +
				"identifierValue=" + this.identifierValue +
			'}';
		}
	}
}
