package cdm.product.template;

import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.meta.ForwardPayoutMeta;
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
 * Represents a forward settling payout. The &#39;Underlier&#39; attribute captures the underlying payout, which is settled according to the &#39;SettlementTerms&#39; attribute. Both FX Spot and FX Forward should use this component.
 * @version ${project.version}
 */
@RosettaClass

public interface ForwardPayout extends RosettaModelObject {
	ForwardPayout build();
	ForwardPayout.ForwardPayoutBuilder toBuilder();
	
	/**
	 * Settlement terms for the underlier that include the settlement date, settlement method etc.
	 */
	SettlementTerms getSettlementTerms();
	/**
	 * Underlying product that the forward is written on, which can be of any type: FX, a contractual product, a security, etc.
	 */
	Product getUnderlier();
	final static ForwardPayoutMeta metaData = new ForwardPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends ForwardPayout> metaData() {
		return metaData;
	} 
			
	static ForwardPayout.ForwardPayoutBuilder builder() {
		return new ForwardPayout.ForwardPayoutBuilderImpl();
	}
	
	default Class<? extends ForwardPayout> getType() {
		return ForwardPayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.class, getSettlementTerms());
		processRosetta(path.newSubPath("underlier"), processor, Product.class, getUnderlier());
	}
	
	
	interface ForwardPayoutBuilder extends ForwardPayout, RosettaModelObjectBuilder {
		SettlementTerms.SettlementTermsBuilder getOrCreateSettlementTerms();
		SettlementTerms.SettlementTermsBuilder getSettlementTerms();
		Product.ProductBuilder getOrCreateUnderlier();
		Product.ProductBuilder getUnderlier();
		ForwardPayout.ForwardPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		ForwardPayout.ForwardPayoutBuilder setUnderlier(Product underlier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("settlementTerms"), processor, SettlementTerms.SettlementTermsBuilder.class, getSettlementTerms());
			processRosetta(path.newSubPath("underlier"), processor, Product.ProductBuilder.class, getUnderlier());
		}
		
	}
	
	//ForwardPayout.ForwardPayoutImpl
	class ForwardPayoutImpl implements ForwardPayout {
		private final SettlementTerms settlementTerms;
		private final Product underlier;
		
		protected ForwardPayoutImpl(ForwardPayout.ForwardPayoutBuilder builder) {
			this.settlementTerms = ofNullable(builder.getSettlementTerms()).map(f->f.build()).orElse(null);
			this.underlier = ofNullable(builder.getUnderlier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public SettlementTerms getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public Product getUnderlier() {
			return underlier;
		}
		
		@Override
		public ForwardPayout build() {
			return this;
		}
		
		@Override
		public ForwardPayout.ForwardPayoutBuilder toBuilder() {
			ForwardPayout.ForwardPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ForwardPayout.ForwardPayoutBuilder builder) {
			ofNullable(getSettlementTerms()).ifPresent(builder::setSettlementTerms);
			ofNullable(getUnderlier()).ifPresent(builder::setUnderlier);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ForwardPayout _that = getType().cast(o);
		
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ForwardPayout {" +
				"settlementTerms=" + this.settlementTerms + ", " +
				"underlier=" + this.underlier +
			'}';
		}
	}
	
	//ForwardPayout.ForwardPayoutBuilderImpl
	class ForwardPayoutBuilderImpl implements ForwardPayout.ForwardPayoutBuilder {
	
		protected SettlementTerms.SettlementTermsBuilder settlementTerms;
		protected Product.ProductBuilder underlier;
	
		public ForwardPayoutBuilderImpl() {
		}
	
		@Override
		public SettlementTerms.SettlementTermsBuilder getSettlementTerms() {
			return settlementTerms;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder getOrCreateSettlementTerms() {
			SettlementTerms.SettlementTermsBuilder result;
			if (settlementTerms!=null) {
				result = settlementTerms;
			}
			else {
				result = settlementTerms = SettlementTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public Product.ProductBuilder getUnderlier() {
			return underlier;
		}
		
		@Override
		public Product.ProductBuilder getOrCreateUnderlier() {
			Product.ProductBuilder result;
			if (underlier!=null) {
				result = underlier;
			}
			else {
				result = underlier = Product.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ForwardPayout.ForwardPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		@Override
		public ForwardPayout.ForwardPayoutBuilder setUnderlier(Product underlier) {
			this.underlier = underlier==null?null:underlier.toBuilder();
			return this;
		}
		
		@Override
		public ForwardPayout build() {
			return new ForwardPayout.ForwardPayoutImpl(this);
		}
		
		@Override
		public ForwardPayout.ForwardPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ForwardPayout.ForwardPayoutBuilder prune() {
			if (settlementTerms!=null && !settlementTerms.prune().hasData()) settlementTerms = null;
			if (underlier!=null && !underlier.prune().hasData()) underlier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementTerms()!=null && getSettlementTerms().hasData()) return true;
			if (getUnderlier()!=null && getUnderlier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ForwardPayout.ForwardPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ForwardPayout.ForwardPayoutBuilder o = (ForwardPayout.ForwardPayoutBuilder) other;
			
			merger.mergeRosetta(getSettlementTerms(), o.getSettlementTerms(), this::setSettlementTerms);
			merger.mergeRosetta(getUnderlier(), o.getUnderlier(), this::setUnderlier);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ForwardPayout _that = getType().cast(o);
		
			if (!Objects.equals(settlementTerms, _that.getSettlementTerms())) return false;
			if (!Objects.equals(underlier, _that.getUnderlier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementTerms != null ? settlementTerms.hashCode() : 0);
			_result = 31 * _result + (underlier != null ? underlier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ForwardPayoutBuilder {" +
				"settlementTerms=" + this.settlementTerms + ", " +
				"underlier=" + this.underlier +
			'}';
		}
	}
}
