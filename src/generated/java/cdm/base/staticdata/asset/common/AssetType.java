package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.AssetTypeMeta;
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
 * A class to allow specification of the asset product type.
 * @version ${project.version}
 */
@RosettaClass

public interface AssetType extends RosettaModelObject {
	AssetType build();
	AssetType.AssetTypeBuilder toBuilder();
	
	/**
	 * The type of collateral asset.
	 */
	AssetTypeEnum getAssetType();
	/**
	 * Filter based on the type of bond.
	 */
	DebtType getDebtType();
	/**
	 * Filter based on the type of equity.
	 */
	EquityTypeEnum getEquityType();
	/**
	 * Filter based on the type of fund.
	 */
	FundProductTypeEnum getFundType();
	/**
	 * Filter based on the type of security.
	 */
	SecurityTypeEnum getSecurityType();
	final static AssetTypeMeta metaData = new AssetTypeMeta();
	
	@Override
	default RosettaMetaData<? extends AssetType> metaData() {
		return metaData;
	} 
			
	static AssetType.AssetTypeBuilder builder() {
		return new AssetType.AssetTypeBuilderImpl();
	}
	
	default Class<? extends AssetType> getType() {
		return AssetType.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("assetType"), AssetTypeEnum.class, getAssetType(), this);
		processor.processBasic(path.newSubPath("equityType"), EquityTypeEnum.class, getEquityType(), this);
		processor.processBasic(path.newSubPath("fundType"), FundProductTypeEnum.class, getFundType(), this);
		processor.processBasic(path.newSubPath("securityType"), SecurityTypeEnum.class, getSecurityType(), this);
		
		processRosetta(path.newSubPath("debtType"), processor, DebtType.class, getDebtType());
	}
	
	
	interface AssetTypeBuilder extends AssetType, RosettaModelObjectBuilder {
		DebtType.DebtTypeBuilder getOrCreateDebtType();
		DebtType.DebtTypeBuilder getDebtType();
		AssetType.AssetTypeBuilder setAssetType(AssetTypeEnum assetType);
		AssetType.AssetTypeBuilder setDebtType(DebtType debtType);
		AssetType.AssetTypeBuilder setEquityType(EquityTypeEnum equityType);
		AssetType.AssetTypeBuilder setFundType(FundProductTypeEnum fundType);
		AssetType.AssetTypeBuilder setSecurityType(SecurityTypeEnum securityType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("assetType"), AssetTypeEnum.class, getAssetType(), this);
			processor.processBasic(path.newSubPath("equityType"), EquityTypeEnum.class, getEquityType(), this);
			processor.processBasic(path.newSubPath("fundType"), FundProductTypeEnum.class, getFundType(), this);
			processor.processBasic(path.newSubPath("securityType"), SecurityTypeEnum.class, getSecurityType(), this);
			
			processRosetta(path.newSubPath("debtType"), processor, DebtType.DebtTypeBuilder.class, getDebtType());
		}
		
	}
	
	//AssetType.AssetTypeImpl
	class AssetTypeImpl implements AssetType {
		private final AssetTypeEnum assetType;
		private final DebtType debtType;
		private final EquityTypeEnum equityType;
		private final FundProductTypeEnum fundType;
		private final SecurityTypeEnum securityType;
		
		protected AssetTypeImpl(AssetType.AssetTypeBuilder builder) {
			this.assetType = builder.getAssetType();
			this.debtType = ofNullable(builder.getDebtType()).map(f->f.build()).orElse(null);
			this.equityType = builder.getEquityType();
			this.fundType = builder.getFundType();
			this.securityType = builder.getSecurityType();
		}
		
		@Override
		public AssetTypeEnum getAssetType() {
			return assetType;
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
		public AssetType build() {
			return this;
		}
		
		@Override
		public AssetType.AssetTypeBuilder toBuilder() {
			AssetType.AssetTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AssetType.AssetTypeBuilder builder) {
			ofNullable(getAssetType()).ifPresent(builder::setAssetType);
			ofNullable(getDebtType()).ifPresent(builder::setDebtType);
			ofNullable(getEquityType()).ifPresent(builder::setEquityType);
			ofNullable(getFundType()).ifPresent(builder::setFundType);
			ofNullable(getSecurityType()).ifPresent(builder::setSecurityType);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetType _that = getType().cast(o);
		
			if (!Objects.equals(assetType, _that.getAssetType())) return false;
			if (!Objects.equals(debtType, _that.getDebtType())) return false;
			if (!Objects.equals(equityType, _that.getEquityType())) return false;
			if (!Objects.equals(fundType, _that.getFundType())) return false;
			if (!Objects.equals(securityType, _that.getSecurityType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetType != null ? assetType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtType != null ? debtType.hashCode() : 0);
			_result = 31 * _result + (equityType != null ? equityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fundType != null ? fundType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securityType != null ? securityType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetType {" +
				"assetType=" + this.assetType + ", " +
				"debtType=" + this.debtType + ", " +
				"equityType=" + this.equityType + ", " +
				"fundType=" + this.fundType + ", " +
				"securityType=" + this.securityType +
			'}';
		}
	}
	
	//AssetType.AssetTypeBuilderImpl
	class AssetTypeBuilderImpl implements AssetType.AssetTypeBuilder {
	
		protected AssetTypeEnum assetType;
		protected DebtType.DebtTypeBuilder debtType;
		protected EquityTypeEnum equityType;
		protected FundProductTypeEnum fundType;
		protected SecurityTypeEnum securityType;
	
		public AssetTypeBuilderImpl() {
		}
	
		@Override
		public AssetTypeEnum getAssetType() {
			return assetType;
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
		public AssetType.AssetTypeBuilder setAssetType(AssetTypeEnum assetType) {
			this.assetType = assetType==null?null:assetType;
			return this;
		}
		@Override
		public AssetType.AssetTypeBuilder setDebtType(DebtType debtType) {
			this.debtType = debtType==null?null:debtType.toBuilder();
			return this;
		}
		@Override
		public AssetType.AssetTypeBuilder setEquityType(EquityTypeEnum equityType) {
			this.equityType = equityType==null?null:equityType;
			return this;
		}
		@Override
		public AssetType.AssetTypeBuilder setFundType(FundProductTypeEnum fundType) {
			this.fundType = fundType==null?null:fundType;
			return this;
		}
		@Override
		public AssetType.AssetTypeBuilder setSecurityType(SecurityTypeEnum securityType) {
			this.securityType = securityType==null?null:securityType;
			return this;
		}
		
		@Override
		public AssetType build() {
			return new AssetType.AssetTypeImpl(this);
		}
		
		@Override
		public AssetType.AssetTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetType.AssetTypeBuilder prune() {
			if (debtType!=null && !debtType.prune().hasData()) debtType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAssetType()!=null) return true;
			if (getDebtType()!=null && getDebtType().hasData()) return true;
			if (getEquityType()!=null) return true;
			if (getFundType()!=null) return true;
			if (getSecurityType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AssetType.AssetTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AssetType.AssetTypeBuilder o = (AssetType.AssetTypeBuilder) other;
			
			merger.mergeRosetta(getDebtType(), o.getDebtType(), this::setDebtType);
			
			merger.mergeBasic(getAssetType(), o.getAssetType(), this::setAssetType);
			merger.mergeBasic(getEquityType(), o.getEquityType(), this::setEquityType);
			merger.mergeBasic(getFundType(), o.getFundType(), this::setFundType);
			merger.mergeBasic(getSecurityType(), o.getSecurityType(), this::setSecurityType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AssetType _that = getType().cast(o);
		
			if (!Objects.equals(assetType, _that.getAssetType())) return false;
			if (!Objects.equals(debtType, _that.getDebtType())) return false;
			if (!Objects.equals(equityType, _that.getEquityType())) return false;
			if (!Objects.equals(fundType, _that.getFundType())) return false;
			if (!Objects.equals(securityType, _that.getSecurityType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (assetType != null ? assetType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtType != null ? debtType.hashCode() : 0);
			_result = 31 * _result + (equityType != null ? equityType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fundType != null ? fundType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (securityType != null ? securityType.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AssetTypeBuilder {" +
				"assetType=" + this.assetType + ", " +
				"debtType=" + this.debtType + ", " +
				"equityType=" + this.equityType + ", " +
				"fundType=" + this.fundType + ", " +
				"securityType=" + this.securityType +
			'}';
		}
	}
}
