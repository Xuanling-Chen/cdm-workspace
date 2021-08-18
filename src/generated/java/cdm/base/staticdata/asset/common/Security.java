package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.ProductBase.ProductBaseBuilder;
import cdm.base.staticdata.asset.common.ProductBase.ProductBaseBuilderImpl;
import cdm.base.staticdata.asset.common.ProductBase.ProductBaseImpl;
import cdm.base.staticdata.asset.common.meta.SecurityMeta;
import cdm.base.staticdata.asset.common.metafields.ReferenceWithMetaProductIdentifier;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Identifies a security by referencing a product identifier and by specifying the sector.
 * @version ${project.version}
 */
@RosettaClass

public interface Security extends ProductBase {
	Security build();
	Security.SecurityBuilder toBuilder();
	
	/**
	 * Identifies the type of debt and selected debt economics.
	 */
	DebtType getDebtType();
	/**
	 * Identifies the type of equity.
	 */
	EquityTypeEnum getEquityType();
	/**
	 * Identifies the type of fund.
	 */
	FundProductTypeEnum getFundType();
	/**
	 * Identifies the type of security using an enumerated list.
	 */
	SecurityTypeEnum getSecurityType();
	final static SecurityMeta metaData = new SecurityMeta();
	
	@Override
	default RosettaMetaData<? extends Security> metaData() {
		return metaData;
	} 
			
	static Security.SecurityBuilder builder() {
		return new Security.SecurityBuilderImpl();
	}
	
	default Class<? extends Security> getType() {
		return Security.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.asset.common.ProductBase.super.process(path, processor);
		processor.processBasic(path.newSubPath("equityType"), EquityTypeEnum.class, getEquityType(), this);
		processor.processBasic(path.newSubPath("fundType"), FundProductTypeEnum.class, getFundType(), this);
		processor.processBasic(path.newSubPath("securityType"), SecurityTypeEnum.class, getSecurityType(), this);
		
		processRosetta(path.newSubPath("debtType"), processor, DebtType.class, getDebtType());
	}
	
	
	interface SecurityBuilder extends Security, ProductBase.ProductBaseBuilder, RosettaModelObjectBuilder {
		DebtType.DebtTypeBuilder getOrCreateDebtType();
		DebtType.DebtTypeBuilder getDebtType();
		Security.SecurityBuilder setDebtType(DebtType debtType);
		Security.SecurityBuilder setEquityType(EquityTypeEnum equityType);
		Security.SecurityBuilder setFundType(FundProductTypeEnum fundType);
		Security.SecurityBuilder setSecurityType(SecurityTypeEnum securityType);
		Security.SecurityBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier);
		Security.SecurityBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx);
		Security.SecurityBuilder addProductIdentifierValue(ProductIdentifier productIdentifier);
		Security.SecurityBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx);
		Security.SecurityBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		Security.SecurityBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifier);
		Security.SecurityBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		Security.SecurityBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			ProductBase.ProductBaseBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("equityType"), EquityTypeEnum.class, getEquityType(), this);
			processor.processBasic(path.newSubPath("fundType"), FundProductTypeEnum.class, getFundType(), this);
			processor.processBasic(path.newSubPath("securityType"), SecurityTypeEnum.class, getSecurityType(), this);
			
			processRosetta(path.newSubPath("debtType"), processor, DebtType.DebtTypeBuilder.class, getDebtType());
		}
		
	}
	
	//Security.SecurityImpl
	class SecurityImpl extends ProductBase.ProductBaseImpl implements Security {
		private final DebtType debtType;
		private final EquityTypeEnum equityType;
		private final FundProductTypeEnum fundType;
		private final SecurityTypeEnum securityType;
		
		protected SecurityImpl(Security.SecurityBuilder builder) {
			super(builder);
			this.debtType = ofNullable(builder.getDebtType()).map(f->f.build()).orElse(null);
			this.equityType = builder.getEquityType();
			this.fundType = builder.getFundType();
			this.securityType = builder.getSecurityType();
		}
		
		@Override
		public DebtType getDebtType() {
			return debtType;
		}
		
		@Override
		public EquityTypeEnum getEquityType() {
			return equityType;
		}
		
		@Override
		public FundProductTypeEnum getFundType() {
			return fundType;
		}
		
		@Override
		public SecurityTypeEnum getSecurityType() {
			return securityType;
		}
		
		@Override
		public Security build() {
			return this;
		}
		
		@Override
		public Security.SecurityBuilder toBuilder() {
			Security.SecurityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Security.SecurityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDebtType()).ifPresent(builder::setDebtType);
			ofNullable(getEquityType()).ifPresent(builder::setEquityType);
			ofNullable(getFundType()).ifPresent(builder::setFundType);
			ofNullable(getSecurityType()).ifPresent(builder::setSecurityType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Security _that = getType().cast(o);
		
			if (!Objects.equals(debtType, _that.getDebtType())) return false;
			if (!Objects.equals(equityType, _that.getEquityType())) return false;
			if (!Objects.equals(fundType, _that.getFundType())) return false;
			if (!Objects.equals(securityType, _that.getSecurityType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (debtType != null ? debtType.hashCode() : 0);
			_result = 31 * _result + (equityType != null ? equityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fundType != null ? fundType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securityType != null ? securityType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Security {" +
				"debtType=" + this.debtType + ", " +
				"equityType=" + this.equityType + ", " +
				"fundType=" + this.fundType + ", " +
				"securityType=" + this.securityType +
			'}' + " " + super.toString();
		}
	}
	
	//Security.SecurityBuilderImpl
	class SecurityBuilderImpl extends ProductBase.ProductBaseBuilderImpl  implements Security.SecurityBuilder {
	
		protected DebtType.DebtTypeBuilder debtType;
		protected EquityTypeEnum equityType;
		protected FundProductTypeEnum fundType;
		protected SecurityTypeEnum securityType;
	
		public SecurityBuilderImpl() {
		}
	
		@Override
		public DebtType.DebtTypeBuilder getDebtType() {
			return debtType;
		}
		
		@Override
		public DebtType.DebtTypeBuilder getOrCreateDebtType() {
			DebtType.DebtTypeBuilder result;
			if (debtType!=null) {
				result = debtType;
			}
			else {
				result = debtType = DebtType.builder();
			}
			
			return result;
		}
		
		@Override
		public EquityTypeEnum getEquityType() {
			return equityType;
		}
		
		@Override
		public FundProductTypeEnum getFundType() {
			return fundType;
		}
		
		@Override
		public SecurityTypeEnum getSecurityType() {
			return securityType;
		}
		
	
		@Override
		public Security.SecurityBuilder setDebtType(DebtType debtType) {
			this.debtType = debtType==null?null:debtType.toBuilder();
			return this;
		}
		@Override
		public Security.SecurityBuilder setEquityType(EquityTypeEnum equityType) {
			this.equityType = equityType==null?null:equityType;
			return this;
		}
		@Override
		public Security.SecurityBuilder setFundType(FundProductTypeEnum fundType) {
			this.fundType = fundType==null?null:fundType;
			return this;
		}
		@Override
		public Security.SecurityBuilder setSecurityType(SecurityTypeEnum securityType) {
			this.securityType = securityType==null?null:securityType;
			return this;
		}
		@Override
		public Security.SecurityBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier) {
			if (productIdentifier!=null) this.productIdentifier.add(productIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addProductIdentifier(ReferenceWithMetaProductIdentifier productIdentifier, int _idx) {
			getIndex(this.productIdentifier, _idx, () -> productIdentifier.toBuilder());
			return this;
		}
		
			@Override
			public Security.SecurityBuilder addProductIdentifierValue(ProductIdentifier productIdentifier) {
				this.getOrCreateProductIdentifier(-1).setValue(productIdentifier.toBuilder());
				return this;
			}
			
			@Override
			public Security.SecurityBuilder addProductIdentifierValue(ProductIdentifier productIdentifier, int _idx) {
				this.getOrCreateProductIdentifier(_idx).setValue(productIdentifier.toBuilder());
				return this;
			}
		@Override 
		public Security.SecurityBuilder addProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ReferenceWithMetaProductIdentifier toAdd : productIdentifiers) {
					this.productIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Security.SecurityBuilder setProductIdentifier(List<? extends ReferenceWithMetaProductIdentifier> productIdentifiers) {
			if (productIdentifiers == null)  {
				this.productIdentifier = new ArrayList<>();
			}
			else {
				this.productIdentifier = productIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public Security.SecurityBuilder addProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			if (productIdentifiers != null) {
				for (ProductIdentifier toAdd : productIdentifiers) {
					this.addProductIdentifierValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public Security.SecurityBuilder setProductIdentifierValue(List<? extends ProductIdentifier> productIdentifiers) {
			this.productIdentifier.clear();
			if (productIdentifiers!=null) {
				productIdentifiers.forEach(this::addProductIdentifierValue);
			}
			return this;
		}
		
		
		@Override
		public Security build() {
			return new Security.SecurityImpl(this);
		}
		
		@Override
		public Security.SecurityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Security.SecurityBuilder prune() {
			super.prune();
			if (debtType!=null && !debtType.prune().hasData()) debtType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDebtType()!=null && getDebtType().hasData()) return true;
			if (getEquityType()!=null) return true;
			if (getFundType()!=null) return true;
			if (getSecurityType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Security.SecurityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Security.SecurityBuilder o = (Security.SecurityBuilder) other;
			
			merger.mergeRosetta(getDebtType(), o.getDebtType(), this::setDebtType);
			
			merger.mergeBasic(getEquityType(), o.getEquityType(), this::setEquityType);
			merger.mergeBasic(getFundType(), o.getFundType(), this::setFundType);
			merger.mergeBasic(getSecurityType(), o.getSecurityType(), this::setSecurityType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			Security _that = getType().cast(o);
		
			if (!Objects.equals(debtType, _that.getDebtType())) return false;
			if (!Objects.equals(equityType, _that.getEquityType())) return false;
			if (!Objects.equals(fundType, _that.getFundType())) return false;
			if (!Objects.equals(securityType, _that.getSecurityType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (debtType != null ? debtType.hashCode() : 0);
			_result = 31 * _result + (equityType != null ? equityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fundType != null ? fundType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securityType != null ? securityType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SecurityBuilder {" +
				"debtType=" + this.debtType + ", " +
				"equityType=" + this.equityType + ", " +
				"fundType=" + this.fundType + ", " +
				"securityType=" + this.securityType +
			'}' + " " + super.toString();
		}
	}
}
