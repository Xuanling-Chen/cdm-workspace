package cdm.product.asset;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.observable.asset.TransactedPrice;
import cdm.product.asset.meta.CreditDefaultPayoutMeta;
import cdm.product.common.settlement.PayoutBase;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilder;
import cdm.product.common.settlement.PayoutBase.PayoutBaseBuilderImpl;
import cdm.product.common.settlement.PayoutBase.PayoutBaseImpl;
import cdm.product.common.settlement.ResolvablePayoutQuantity;
import cdm.product.common.settlement.SettlementTerms;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.GlobalKey;
import com.rosetta.model.lib.GlobalKey.GlobalKeyBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 *  The credit default payout specification provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms. The associated globalKey denotes the ability to associate a hash value to the CreditDefaultPayout instantiations for the purpose of model cross-referencing, in support of functionality such as the event effect and the lineage.
 * @version ${project.version}
 */
@RosettaClass

public interface CreditDefaultPayout extends PayoutBase, GlobalKey {
	CreditDefaultPayout build();
	CreditDefaultPayout.CreditDefaultPayoutBuilder toBuilder();
	
	/**
	 * The specification of the non-monetary terms for the Credit Derivative Transaction, including the buyer and seller and selected items from the ISDA 2014 Credit Definition article II, such as the reference obligation and related terms.
	 */
	GeneralTerms getGeneralTerms();
	/**
	 */
	MetaFields getMeta();
	/**
	 * Specifies the terms for calculating a payout to protect the buyer of the swap in the case of a qualified credit event. These terms include the applicable credit events, the reference obligation, and in the case of a CDS on mortgage-backed securities, the floatingAmountEvents.
	 */
	List<? extends ProtectionTerms> getProtectionTerms();
	/**
	 * The qualification of the price at which the contract has been transacted, in terms of market fixed rate, initial points, market price and/or quotation style. In FpML, those attributes are positioned as part of the fee leg.
	 */
	TransactedPrice getTransactedPrice();
	final static CreditDefaultPayoutMeta metaData = new CreditDefaultPayoutMeta();
	
	@Override
	default RosettaMetaData<? extends CreditDefaultPayout> metaData() {
		return metaData;
	} 
			
	static CreditDefaultPayout.CreditDefaultPayoutBuilder builder() {
		return new CreditDefaultPayout.CreditDefaultPayoutBuilderImpl();
	}
	
	default Class<? extends CreditDefaultPayout> getType() {
		return CreditDefaultPayout.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.PayoutBase.super.process(path, processor);
		
		processRosetta(path.newSubPath("generalTerms"), processor, GeneralTerms.class, getGeneralTerms());
		processRosetta(path.newSubPath("meta"), processor, MetaFields.class, getMeta());
		processRosetta(path.newSubPath("protectionTerms"), processor, ProtectionTerms.class, getProtectionTerms());
		processRosetta(path.newSubPath("transactedPrice"), processor, TransactedPrice.class, getTransactedPrice());
	}
	
	
	interface CreditDefaultPayoutBuilder extends CreditDefaultPayout, PayoutBase.PayoutBaseBuilder, RosettaModelObjectBuilder {
		GeneralTerms.GeneralTermsBuilder getOrCreateGeneralTerms();
		GeneralTerms.GeneralTermsBuilder getGeneralTerms();
		MetaFields.MetaFieldsBuilder getOrCreateMeta();
		MetaFields.MetaFieldsBuilder getMeta();
		ProtectionTerms.ProtectionTermsBuilder getOrCreateProtectionTerms(int _index);
		List<? extends ProtectionTerms.ProtectionTermsBuilder> getProtectionTerms();
		TransactedPrice.TransactedPriceBuilder getOrCreateTransactedPrice();
		TransactedPrice.TransactedPriceBuilder getTransactedPrice();
		CreditDefaultPayout.CreditDefaultPayoutBuilder setGeneralTerms(GeneralTerms generalTerms);
		CreditDefaultPayout.CreditDefaultPayoutBuilder setMeta(MetaFields meta);
		CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(ProtectionTerms protectionTerms);
		CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(ProtectionTerms protectionTerms, int _idx);
		CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(List<? extends ProtectionTerms> protectionTerms);
		CreditDefaultPayout.CreditDefaultPayoutBuilder setProtectionTerms(List<? extends ProtectionTerms> protectionTerms);
		CreditDefaultPayout.CreditDefaultPayoutBuilder setTransactedPrice(TransactedPrice transactedPrice);
		CreditDefaultPayout.CreditDefaultPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver);
		CreditDefaultPayout.CreditDefaultPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity);
		CreditDefaultPayout.CreditDefaultPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			PayoutBase.PayoutBaseBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("generalTerms"), processor, GeneralTerms.GeneralTermsBuilder.class, getGeneralTerms());
			processRosetta(path.newSubPath("meta"), processor, MetaFields.MetaFieldsBuilder.class, getMeta());
			processRosetta(path.newSubPath("protectionTerms"), processor, ProtectionTerms.ProtectionTermsBuilder.class, getProtectionTerms());
			processRosetta(path.newSubPath("transactedPrice"), processor, TransactedPrice.TransactedPriceBuilder.class, getTransactedPrice());
		}
		
	}
	
	//CreditDefaultPayout.CreditDefaultPayoutImpl
	class CreditDefaultPayoutImpl extends PayoutBase.PayoutBaseImpl implements CreditDefaultPayout {
		private final GeneralTerms generalTerms;
		private final MetaFields meta;
		private final List<? extends ProtectionTerms> protectionTerms;
		private final TransactedPrice transactedPrice;
		
		protected CreditDefaultPayoutImpl(CreditDefaultPayout.CreditDefaultPayoutBuilder builder) {
			super(builder);
			this.generalTerms = ofNullable(builder.getGeneralTerms()).map(f->f.build()).orElse(null);
			this.meta = ofNullable(builder.getMeta()).map(f->f.build()).orElse(null);
			this.protectionTerms = ofNullable(builder.getProtectionTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.transactedPrice = ofNullable(builder.getTransactedPrice()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public GeneralTerms getGeneralTerms() {
			return generalTerms;
		}
		
		@Override
		public MetaFields getMeta() {
			return meta;
		}
		
		@Override
		public List<? extends ProtectionTerms> getProtectionTerms() {
			return protectionTerms;
		}
		
		@Override
		public TransactedPrice getTransactedPrice() {
			return transactedPrice;
		}
		
		@Override
		public CreditDefaultPayout build() {
			return this;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder toBuilder() {
			CreditDefaultPayout.CreditDefaultPayoutBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditDefaultPayout.CreditDefaultPayoutBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getGeneralTerms()).ifPresent(builder::setGeneralTerms);
			ofNullable(getMeta()).ifPresent(builder::setMeta);
			ofNullable(getProtectionTerms()).ifPresent(builder::setProtectionTerms);
			ofNullable(getTransactedPrice()).ifPresent(builder::setTransactedPrice);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultPayout _that = getType().cast(o);
		
			if (!Objects.equals(generalTerms, _that.getGeneralTerms())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(protectionTerms, _that.getProtectionTerms())) return false;
			if (!Objects.equals(transactedPrice, _that.getTransactedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (generalTerms != null ? generalTerms.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (protectionTerms != null ? protectionTerms.hashCode() : 0);
			_result = 31 * _result + (transactedPrice != null ? transactedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultPayout {" +
				"generalTerms=" + this.generalTerms + ", " +
				"meta=" + this.meta + ", " +
				"protectionTerms=" + this.protectionTerms + ", " +
				"transactedPrice=" + this.transactedPrice +
			'}' + " " + super.toString();
		}
	}
	
	//CreditDefaultPayout.CreditDefaultPayoutBuilderImpl
	class CreditDefaultPayoutBuilderImpl extends PayoutBase.PayoutBaseBuilderImpl  implements CreditDefaultPayout.CreditDefaultPayoutBuilder, GlobalKeyBuilder {
	
		protected GeneralTerms.GeneralTermsBuilder generalTerms;
		protected MetaFields.MetaFieldsBuilder meta;
		protected List<ProtectionTerms.ProtectionTermsBuilder> protectionTerms = new ArrayList<>();
		protected TransactedPrice.TransactedPriceBuilder transactedPrice;
	
		public CreditDefaultPayoutBuilderImpl() {
		}
	
		@Override
		public GeneralTerms.GeneralTermsBuilder getGeneralTerms() {
			return generalTerms;
		}
		
		@Override
		public GeneralTerms.GeneralTermsBuilder getOrCreateGeneralTerms() {
			GeneralTerms.GeneralTermsBuilder result;
			if (generalTerms!=null) {
				result = generalTerms;
			}
			else {
				result = generalTerms = GeneralTerms.builder();
			}
			
			return result;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getMeta() {
			return meta;
		}
		
		@Override
		public MetaFields.MetaFieldsBuilder getOrCreateMeta() {
			MetaFields.MetaFieldsBuilder result;
			if (meta!=null) {
				result = meta;
			}
			else {
				result = meta = MetaFields.builder();
			}
			
			return result;
		}
		
		@Override
		public List<? extends ProtectionTerms.ProtectionTermsBuilder> getProtectionTerms() {
			return protectionTerms;
		}
		
		public ProtectionTerms.ProtectionTermsBuilder getOrCreateProtectionTerms(int _index) {
		
			if (protectionTerms==null) {
				this.protectionTerms = new ArrayList<>();
			}
			ProtectionTerms.ProtectionTermsBuilder result;
			return getIndex(protectionTerms, _index, () -> {
						ProtectionTerms.ProtectionTermsBuilder newProtectionTerms = ProtectionTerms.builder();
						return newProtectionTerms;
					});
		}
		
		@Override
		public TransactedPrice.TransactedPriceBuilder getTransactedPrice() {
			return transactedPrice;
		}
		
		@Override
		public TransactedPrice.TransactedPriceBuilder getOrCreateTransactedPrice() {
			TransactedPrice.TransactedPriceBuilder result;
			if (transactedPrice!=null) {
				result = transactedPrice;
			}
			else {
				result = transactedPrice = TransactedPrice.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setGeneralTerms(GeneralTerms generalTerms) {
			this.generalTerms = generalTerms==null?null:generalTerms.toBuilder();
			return this;
		}
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(ProtectionTerms protectionTerms) {
			if (protectionTerms!=null) this.protectionTerms.add(protectionTerms.toBuilder());
			return this;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(ProtectionTerms protectionTerms, int _idx) {
			getIndex(this.protectionTerms, _idx, () -> protectionTerms.toBuilder());
			return this;
		}
		@Override 
		public CreditDefaultPayout.CreditDefaultPayoutBuilder addProtectionTerms(List<? extends ProtectionTerms> protectionTermss) {
			if (protectionTermss != null) {
				for (ProtectionTerms toAdd : protectionTermss) {
					this.protectionTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setProtectionTerms(List<? extends ProtectionTerms> protectionTermss) {
			if (protectionTermss == null)  {
				this.protectionTerms = new ArrayList<>();
			}
			else {
				this.protectionTerms = protectionTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setTransactedPrice(TransactedPrice transactedPrice) {
			this.transactedPrice = transactedPrice==null?null:transactedPrice.toBuilder();
			return this;
		}
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setPayerReceiver(PayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setPayoutQuantity(ResolvablePayoutQuantity payoutQuantity) {
			this.payoutQuantity = payoutQuantity==null?null:payoutQuantity.toBuilder();
			return this;
		}
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder setSettlementTerms(SettlementTerms settlementTerms) {
			this.settlementTerms = settlementTerms==null?null:settlementTerms.toBuilder();
			return this;
		}
		
		@Override
		public CreditDefaultPayout build() {
			return new CreditDefaultPayout.CreditDefaultPayoutImpl(this);
		}
		
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder prune() {
			super.prune();
			if (generalTerms!=null && !generalTerms.prune().hasData()) generalTerms = null;
			if (meta!=null && !meta.prune().hasData()) meta = null;
			protectionTerms = protectionTerms.stream().filter(b->b!=null).<ProtectionTerms.ProtectionTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (transactedPrice!=null && !transactedPrice.prune().hasData()) transactedPrice = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getGeneralTerms()!=null && getGeneralTerms().hasData()) return true;
			if (getProtectionTerms()!=null && getProtectionTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTransactedPrice()!=null && getTransactedPrice().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditDefaultPayout.CreditDefaultPayoutBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CreditDefaultPayout.CreditDefaultPayoutBuilder o = (CreditDefaultPayout.CreditDefaultPayoutBuilder) other;
			
			merger.mergeRosetta(getGeneralTerms(), o.getGeneralTerms(), this::setGeneralTerms);
			merger.mergeRosetta(getMeta(), o.getMeta(), this::setMeta);
			merger.mergeRosetta(getProtectionTerms(), o.getProtectionTerms(), this::getOrCreateProtectionTerms);
			merger.mergeRosetta(getTransactedPrice(), o.getTransactedPrice(), this::setTransactedPrice);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CreditDefaultPayout _that = getType().cast(o);
		
			if (!Objects.equals(generalTerms, _that.getGeneralTerms())) return false;
			if (!Objects.equals(meta, _that.getMeta())) return false;
			if (!ListEquals.listEquals(protectionTerms, _that.getProtectionTerms())) return false;
			if (!Objects.equals(transactedPrice, _that.getTransactedPrice())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (generalTerms != null ? generalTerms.hashCode() : 0);
			_result = 31 * _result + (meta != null ? meta.hashCode() : 0);
			_result = 31 * _result + (protectionTerms != null ? protectionTerms.hashCode() : 0);
			_result = 31 * _result + (transactedPrice != null ? transactedPrice.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditDefaultPayoutBuilder {" +
				"generalTerms=" + this.generalTerms + ", " +
				"meta=" + this.meta + ", " +
				"protectionTerms=" + this.protectionTerms + ", " +
				"transactedPrice=" + this.transactedPrice +
			'}' + " " + super.toString();
		}
	}
}
