package cdm.base.staticdata.party;

import cdm.base.staticdata.party.meta.BuyerSellerMeta;
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
 * This class corresponds to the FpML BuyerSeller.model construct.
 * @version ${project.version}
 */
@RosettaClass

public interface BuyerSeller extends RosettaModelObject {
	BuyerSeller build();
	BuyerSeller.BuyerSellerBuilder toBuilder();
	
	/**
	 * Buyer party that can be resolved as one of the two principal parties to the transaction. The party that buys this instrument, i.e. pays for this instrument and receives the rights defined by it. ISDA 2002 Equity Definitions section 1.18: `Buyer` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (b)(i) relating to a Swaption: &#39;Buyer&#39; means the party that will, on each Premium Payment Date, pay to Seller the Premium | ISDA 2006 Definitions article 12.1 (b)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such in the related Confirmation, or the Exercising Party if neither party is specified | ISDA 2006 Definitions article 12.1 (b)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Buyer` means the Fixed Rate Payer.
	 */
	CounterpartyRoleEnum getBuyer();
	/**
	 * Seller party that can be resolved as one of the two principal parties to the transaction. The party that sells (&#39;writes&#39;) this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. ISDA 2002 Equity Definitions section 1.19: `Seller` means the party specified as such in the related Confirmation. | ISDA 2006 Definitions article 12.1 (a)(i) relating to a Swaption: &#39;Seller&#39; means the party the party specified as such or as writer in the related Confirmation | ISDA 2006 Definitions article 12.1 (a)(ii) relating to Swap Transactions with applicable Early Termination: the party specified as such or as writer in the related Confirmation or, if neither party is specified as such, the Non-exercising Party | ISDA 2006 Definitions article 12.1 (a)(iii) relating to any other Option Transaction: the party specified as such in the related Confirmation. | ISDA 2014 Credit Definition article 1.4: `Seller` means the Floating Rate Payer.
	 */
	CounterpartyRoleEnum getSeller();
	final static BuyerSellerMeta metaData = new BuyerSellerMeta();
	
	@Override
	default RosettaMetaData<? extends BuyerSeller> metaData() {
		return metaData;
	} 
			
	static BuyerSeller.BuyerSellerBuilder builder() {
		return new BuyerSeller.BuyerSellerBuilderImpl();
	}
	
	default Class<? extends BuyerSeller> getType() {
		return BuyerSeller.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("buyer"), CounterpartyRoleEnum.class, getBuyer(), this);
		processor.processBasic(path.newSubPath("seller"), CounterpartyRoleEnum.class, getSeller(), this);
		
	}
	
	
	interface BuyerSellerBuilder extends BuyerSeller, RosettaModelObjectBuilder {
		BuyerSeller.BuyerSellerBuilder setBuyer(CounterpartyRoleEnum buyer);
		BuyerSeller.BuyerSellerBuilder setSeller(CounterpartyRoleEnum seller);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("buyer"), CounterpartyRoleEnum.class, getBuyer(), this);
			processor.processBasic(path.newSubPath("seller"), CounterpartyRoleEnum.class, getSeller(), this);
			
		}
		
	}
	
	//BuyerSeller.BuyerSellerImpl
	class BuyerSellerImpl implements BuyerSeller {
		private final CounterpartyRoleEnum buyer;
		private final CounterpartyRoleEnum seller;
		
		protected BuyerSellerImpl(BuyerSeller.BuyerSellerBuilder builder) {
			this.buyer = builder.getBuyer();
			this.seller = builder.getSeller();
		}
		
		@Override
		public CounterpartyRoleEnum getBuyer() {
			return buyer;
		}
		
		@Override
		public CounterpartyRoleEnum getSeller() {
			return seller;
		}
		
		@Override
		public BuyerSeller build() {
			return this;
		}
		
		@Override
		public BuyerSeller.BuyerSellerBuilder toBuilder() {
			BuyerSeller.BuyerSellerBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BuyerSeller.BuyerSellerBuilder builder) {
			ofNullable(getBuyer()).ifPresent(builder::setBuyer);
			ofNullable(getSeller()).ifPresent(builder::setSeller);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BuyerSeller _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyer != null ? buyer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BuyerSeller {" +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}';
		}
	}
	
	//BuyerSeller.BuyerSellerBuilderImpl
	class BuyerSellerBuilderImpl implements BuyerSeller.BuyerSellerBuilder {
	
		protected CounterpartyRoleEnum buyer;
		protected CounterpartyRoleEnum seller;
	
		public BuyerSellerBuilderImpl() {
		}
	
		@Override
		public CounterpartyRoleEnum getBuyer() {
			return buyer;
		}
		
		@Override
		public CounterpartyRoleEnum getSeller() {
			return seller;
		}
		
	
		@Override
		public BuyerSeller.BuyerSellerBuilder setBuyer(CounterpartyRoleEnum buyer) {
			this.buyer = buyer==null?null:buyer;
			return this;
		}
		@Override
		public BuyerSeller.BuyerSellerBuilder setSeller(CounterpartyRoleEnum seller) {
			this.seller = seller==null?null:seller;
			return this;
		}
		
		@Override
		public BuyerSeller build() {
			return new BuyerSeller.BuyerSellerImpl(this);
		}
		
		@Override
		public BuyerSeller.BuyerSellerBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BuyerSeller.BuyerSellerBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBuyer()!=null) return true;
			if (getSeller()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BuyerSeller.BuyerSellerBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BuyerSeller.BuyerSellerBuilder o = (BuyerSeller.BuyerSellerBuilder) other;
			
			
			merger.mergeBasic(getBuyer(), o.getBuyer(), this::setBuyer);
			merger.mergeBasic(getSeller(), o.getSeller(), this::setSeller);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BuyerSeller _that = getType().cast(o);
		
			if (!Objects.equals(buyer, _that.getBuyer())) return false;
			if (!Objects.equals(seller, _that.getSeller())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (buyer != null ? buyer.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (seller != null ? seller.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BuyerSellerBuilder {" +
				"buyer=" + this.buyer + ", " +
				"seller=" + this.seller +
			'}';
		}
	}
}
