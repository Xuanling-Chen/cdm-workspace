package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.CommodityProductDefinitionMeta;
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
 * Specifies the commodity underlier in the event that no ISDA Commodity Reference Price exists.
 * @version ${project.version}
 */
@RosettaClass

public interface CommodityProductDefinition extends RosettaModelObject {
	CommodityProductDefinition build();
	CommodityProductDefinition.CommodityProductDefinitionBuilder toBuilder();
	
	/**
	 *  Identifies the exchange from which the reference price should be sourced, using the scheme at the following url: http://www.fpml.org/coding-scheme/external/exchange-id-MIC-1-0
	 */
	FieldWithMetaString getExchangeId();
	/**
	 * Specifies a publication that provides the commodity price, including, where applicable the details of where in the publication the price is published.  Applicable when the commodity reference price is not a futures contract
	 */
	PriceSource getPriceSource();
	/**
	 * Specifies the type of commodity.
	 */
	CommodityReferenceFramework getReferenceFramework();
	final static CommodityProductDefinitionMeta metaData = new CommodityProductDefinitionMeta();
	
	@Override
	default RosettaMetaData<? extends CommodityProductDefinition> metaData() {
		return metaData;
	} 
			
	static CommodityProductDefinition.CommodityProductDefinitionBuilder builder() {
		return new CommodityProductDefinition.CommodityProductDefinitionBuilderImpl();
	}
	
	default Class<? extends CommodityProductDefinition> getType() {
		return CommodityProductDefinition.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("exchangeId"), processor, FieldWithMetaString.class, getExchangeId());
		processRosetta(path.newSubPath("priceSource"), processor, PriceSource.class, getPriceSource());
		processRosetta(path.newSubPath("referenceFramework"), processor, CommodityReferenceFramework.class, getReferenceFramework());
	}
	
	
	interface CommodityProductDefinitionBuilder extends CommodityProductDefinition, RosettaModelObjectBuilder {
		FieldWithMetaStringBuilder getOrCreateExchangeId();
		FieldWithMetaStringBuilder getExchangeId();
		PriceSource.PriceSourceBuilder getOrCreatePriceSource();
		PriceSource.PriceSourceBuilder getPriceSource();
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder getOrCreateReferenceFramework();
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder getReferenceFramework();
		CommodityProductDefinition.CommodityProductDefinitionBuilder setExchangeId(FieldWithMetaString exchangeId);
		CommodityProductDefinition.CommodityProductDefinitionBuilder setExchangeIdValue(String exchangeId);
		CommodityProductDefinition.CommodityProductDefinitionBuilder setPriceSource(PriceSource priceSource);
		CommodityProductDefinition.CommodityProductDefinitionBuilder setReferenceFramework(CommodityReferenceFramework referenceFramework);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("exchangeId"), processor, FieldWithMetaStringBuilder.class, getExchangeId());
			processRosetta(path.newSubPath("priceSource"), processor, PriceSource.PriceSourceBuilder.class, getPriceSource());
			processRosetta(path.newSubPath("referenceFramework"), processor, CommodityReferenceFramework.CommodityReferenceFrameworkBuilder.class, getReferenceFramework());
		}
		
	}
	
	//CommodityProductDefinition.CommodityProductDefinitionImpl
	class CommodityProductDefinitionImpl implements CommodityProductDefinition {
		private final FieldWithMetaString exchangeId;
		private final PriceSource priceSource;
		private final CommodityReferenceFramework referenceFramework;
		
		protected CommodityProductDefinitionImpl(CommodityProductDefinition.CommodityProductDefinitionBuilder builder) {
			this.exchangeId = ofNullable(builder.getExchangeId()).map(f->f.build()).orElse(null);
			this.priceSource = ofNullable(builder.getPriceSource()).map(f->f.build()).orElse(null);
			this.referenceFramework = ofNullable(builder.getReferenceFramework()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public FieldWithMetaString getExchangeId() {
			return exchangeId;
		}
		
		@Override
		public PriceSource getPriceSource() {
			return priceSource;
		}
		
		@Override
		public CommodityReferenceFramework getReferenceFramework() {
			return referenceFramework;
		}
		
		@Override
		public CommodityProductDefinition build() {
			return this;
		}
		
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder toBuilder() {
			CommodityProductDefinition.CommodityProductDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityProductDefinition.CommodityProductDefinitionBuilder builder) {
			ofNullable(getExchangeId()).ifPresent(builder::setExchangeId);
			ofNullable(getPriceSource()).ifPresent(builder::setPriceSource);
			ofNullable(getReferenceFramework()).ifPresent(builder::setReferenceFramework);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductDefinition _that = getType().cast(o);
		
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(priceSource, _that.getPriceSource())) return false;
			if (!Objects.equals(referenceFramework, _that.getReferenceFramework())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (priceSource != null ? priceSource.hashCode() : 0);
			_result = 31 * _result + (referenceFramework != null ? referenceFramework.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductDefinition {" +
				"exchangeId=" + this.exchangeId + ", " +
				"priceSource=" + this.priceSource + ", " +
				"referenceFramework=" + this.referenceFramework +
			'}';
		}
	}
	
	//CommodityProductDefinition.CommodityProductDefinitionBuilderImpl
	class CommodityProductDefinitionBuilderImpl implements CommodityProductDefinition.CommodityProductDefinitionBuilder {
	
		protected FieldWithMetaStringBuilder exchangeId;
		protected PriceSource.PriceSourceBuilder priceSource;
		protected CommodityReferenceFramework.CommodityReferenceFrameworkBuilder referenceFramework;
	
		public CommodityProductDefinitionBuilderImpl() {
		}
	
		@Override
		public FieldWithMetaStringBuilder getExchangeId() {
			return exchangeId;
		}
		
		@Override
		public FieldWithMetaStringBuilder getOrCreateExchangeId() {
			FieldWithMetaStringBuilder result;
			if (exchangeId!=null) {
				result = exchangeId;
			}
			else {
				result = exchangeId = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		public PriceSource.PriceSourceBuilder getPriceSource() {
			return priceSource;
		}
		
		@Override
		public PriceSource.PriceSourceBuilder getOrCreatePriceSource() {
			PriceSource.PriceSourceBuilder result;
			if (priceSource!=null) {
				result = priceSource;
			}
			else {
				result = priceSource = PriceSource.builder();
			}
			
			return result;
		}
		
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder getReferenceFramework() {
			return referenceFramework;
		}
		
		@Override
		public CommodityReferenceFramework.CommodityReferenceFrameworkBuilder getOrCreateReferenceFramework() {
			CommodityReferenceFramework.CommodityReferenceFrameworkBuilder result;
			if (referenceFramework!=null) {
				result = referenceFramework;
			}
			else {
				result = referenceFramework = CommodityReferenceFramework.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder setExchangeId(FieldWithMetaString exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder setExchangeIdValue(String exchangeId) {
			this.getOrCreateExchangeId().setValue(exchangeId);
			return this;
		}
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder setPriceSource(PriceSource priceSource) {
			this.priceSource = priceSource==null?null:priceSource.toBuilder();
			return this;
		}
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder setReferenceFramework(CommodityReferenceFramework referenceFramework) {
			this.referenceFramework = referenceFramework==null?null:referenceFramework.toBuilder();
			return this;
		}
		
		@Override
		public CommodityProductDefinition build() {
			return new CommodityProductDefinition.CommodityProductDefinitionImpl(this);
		}
		
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder prune() {
			if (exchangeId!=null && !exchangeId.prune().hasData()) exchangeId = null;
			if (priceSource!=null && !priceSource.prune().hasData()) priceSource = null;
			if (referenceFramework!=null && !referenceFramework.prune().hasData()) referenceFramework = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExchangeId()!=null) return true;
			if (getPriceSource()!=null && getPriceSource().hasData()) return true;
			if (getReferenceFramework()!=null && getReferenceFramework().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityProductDefinition.CommodityProductDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityProductDefinition.CommodityProductDefinitionBuilder o = (CommodityProductDefinition.CommodityProductDefinitionBuilder) other;
			
			merger.mergeRosetta(getExchangeId(), o.getExchangeId(), this::setExchangeId);
			merger.mergeRosetta(getPriceSource(), o.getPriceSource(), this::setPriceSource);
			merger.mergeRosetta(getReferenceFramework(), o.getReferenceFramework(), this::setReferenceFramework);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityProductDefinition _that = getType().cast(o);
		
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			if (!Objects.equals(priceSource, _that.getPriceSource())) return false;
			if (!Objects.equals(referenceFramework, _that.getReferenceFramework())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			_result = 31 * _result + (priceSource != null ? priceSource.hashCode() : 0);
			_result = 31 * _result + (referenceFramework != null ? referenceFramework.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityProductDefinitionBuilder {" +
				"exchangeId=" + this.exchangeId + ", " +
				"priceSource=" + this.priceSource + ", " +
				"referenceFramework=" + this.referenceFramework +
			'}';
		}
	}
}
