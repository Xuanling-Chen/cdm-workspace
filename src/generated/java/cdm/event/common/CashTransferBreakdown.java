package cdm.event.common;

import cdm.base.staticdata.party.PartyReferencePayerReceiver;
import cdm.event.common.TransferBreakdown.TransferBreakdownBuilder;
import cdm.event.common.TransferBreakdown.TransferBreakdownBuilderImpl;
import cdm.event.common.TransferBreakdown.TransferBreakdownImpl;
import cdm.event.common.meta.CashTransferBreakdownMeta;
import cdm.observable.asset.Money;
import cdm.product.common.settlement.CashflowTypeEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaClass

public interface CashTransferBreakdown extends TransferBreakdown {
	CashTransferBreakdown build();
	CashTransferBreakdown.CashTransferBreakdownBuilder toBuilder();
	
	/**
	 * The currency amount of the payment.
	 */
	Money getAmount();
	/**
	 * The qualification of the type of cashflow, when not inferred from a derived through lineage e.g. brokerage fee, premium, upfront fee etc.
	 */
	CashflowTypeEnum getCashflowType();
	/**
	 * The payer and receiver party information.
	 */
	PartyReferencePayerReceiver getPayerReceiver();
	final static CashTransferBreakdownMeta metaData = new CashTransferBreakdownMeta();
	
	@Override
	default RosettaMetaData<? extends CashTransferBreakdown> metaData() {
		return metaData;
	} 
			
	static CashTransferBreakdown.CashTransferBreakdownBuilder builder() {
		return new CashTransferBreakdown.CashTransferBreakdownBuilderImpl();
	}
	
	default Class<? extends CashTransferBreakdown> getType() {
		return CashTransferBreakdown.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.event.common.TransferBreakdown.super.process(path, processor);
		processor.processBasic(path.newSubPath("cashflowType"), CashflowTypeEnum.class, getCashflowType(), this);
		
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
		processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.class, getPayerReceiver());
	}
	
	
	interface CashTransferBreakdownBuilder extends CashTransferBreakdown, TransferBreakdown.TransferBreakdownBuilder, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver();
		PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver();
		CashTransferBreakdown.CashTransferBreakdownBuilder setAmount(Money amount);
		CashTransferBreakdown.CashTransferBreakdownBuilder setCashflowType(CashflowTypeEnum cashflowType);
		CashTransferBreakdown.CashTransferBreakdownBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver);
		CashTransferBreakdown.CashTransferBreakdownBuilder addLineage(Lineage lineage);
		CashTransferBreakdown.CashTransferBreakdownBuilder addLineage(Lineage lineage, int _idx);
		CashTransferBreakdown.CashTransferBreakdownBuilder addLineage(List<? extends Lineage> lineage);
		CashTransferBreakdown.CashTransferBreakdownBuilder setLineage(List<? extends Lineage> lineage);
		CashTransferBreakdown.CashTransferBreakdownBuilder setIdentifier(FieldWithMetaString identifier);
		CashTransferBreakdown.CashTransferBreakdownBuilder setIdentifierValue(String identifier);
		CashTransferBreakdown.CashTransferBreakdownBuilder setTransferCalculation(TransferCalculation transferCalculation);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			TransferBreakdown.TransferBreakdownBuilder.super.process(path, processor);
			
			processor.processBasic(path.newSubPath("cashflowType"), CashflowTypeEnum.class, getCashflowType(), this);
			
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
			processRosetta(path.newSubPath("payerReceiver"), processor, PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder.class, getPayerReceiver());
		}
		
	}
	
	//CashTransferBreakdown.CashTransferBreakdownImpl
	class CashTransferBreakdownImpl extends TransferBreakdown.TransferBreakdownImpl implements CashTransferBreakdown {
		private final Money amount;
		private final CashflowTypeEnum cashflowType;
		private final PartyReferencePayerReceiver payerReceiver;
		
		protected CashTransferBreakdownImpl(CashTransferBreakdown.CashTransferBreakdownBuilder builder) {
			super(builder);
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.cashflowType = builder.getCashflowType();
			this.payerReceiver = ofNullable(builder.getPayerReceiver()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Money getAmount() {
			return amount;
		}
		
		@Override
		public CashflowTypeEnum getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public PartyReferencePayerReceiver getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public CashTransferBreakdown build() {
			return this;
		}
		
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder toBuilder() {
			CashTransferBreakdown.CashTransferBreakdownBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CashTransferBreakdown.CashTransferBreakdownBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getCashflowType()).ifPresent(builder::setCashflowType);
			ofNullable(getPayerReceiver()).ifPresent(builder::setPayerReceiver);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CashTransferBreakdown _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashTransferBreakdown {" +
				"amount=" + this.amount + ", " +
				"cashflowType=" + this.cashflowType + ", " +
				"payerReceiver=" + this.payerReceiver +
			'}' + " " + super.toString();
		}
	}
	
	//CashTransferBreakdown.CashTransferBreakdownBuilderImpl
	class CashTransferBreakdownBuilderImpl extends TransferBreakdown.TransferBreakdownBuilderImpl  implements CashTransferBreakdown.CashTransferBreakdownBuilder {
	
		protected Money.MoneyBuilder amount;
		protected CashflowTypeEnum cashflowType;
		protected PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder payerReceiver;
	
		public CashTransferBreakdownBuilderImpl() {
		}
	
		@Override
		public Money.MoneyBuilder getAmount() {
			return amount;
		}
		
		@Override
		public Money.MoneyBuilder getOrCreateAmount() {
			Money.MoneyBuilder result;
			if (amount!=null) {
				result = amount;
			}
			else {
				result = amount = Money.builder();
			}
			
			return result;
		}
		
		@Override
		public CashflowTypeEnum getCashflowType() {
			return cashflowType;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getPayerReceiver() {
			return payerReceiver;
		}
		
		@Override
		public PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder getOrCreatePayerReceiver() {
			PartyReferencePayerReceiver.PartyReferencePayerReceiverBuilder result;
			if (payerReceiver!=null) {
				result = payerReceiver;
			}
			else {
				result = payerReceiver = PartyReferencePayerReceiver.builder();
			}
			
			return result;
		}
		
	
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder setCashflowType(CashflowTypeEnum cashflowType) {
			this.cashflowType = cashflowType==null?null:cashflowType;
			return this;
		}
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder setPayerReceiver(PartyReferencePayerReceiver payerReceiver) {
			this.payerReceiver = payerReceiver==null?null:payerReceiver.toBuilder();
			return this;
		}
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder addLineage(Lineage lineage) {
			if (lineage!=null) this.lineage.add(lineage.toBuilder());
			return this;
		}
		
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder addLineage(Lineage lineage, int _idx) {
			getIndex(this.lineage, _idx, () -> lineage.toBuilder());
			return this;
		}
		@Override 
		public CashTransferBreakdown.CashTransferBreakdownBuilder addLineage(List<? extends Lineage> lineages) {
			if (lineages != null) {
				for (Lineage toAdd : lineages) {
					this.lineage.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public CashTransferBreakdown.CashTransferBreakdownBuilder setLineage(List<? extends Lineage> lineages) {
			if (lineages == null)  {
				this.lineage = new ArrayList<>();
			}
			else {
				this.lineage = lineages.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder setIdentifier(FieldWithMetaString identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder setIdentifierValue(String identifier) {
			this.getOrCreateIdentifier().setValue(identifier);
			return this;
		}
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder setTransferCalculation(TransferCalculation transferCalculation) {
			this.transferCalculation = transferCalculation==null?null:transferCalculation.toBuilder();
			return this;
		}
		
		@Override
		public CashTransferBreakdown build() {
			return new CashTransferBreakdown.CashTransferBreakdownImpl(this);
		}
		
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder prune() {
			super.prune();
			if (amount!=null && !amount.prune().hasData()) amount = null;
			if (payerReceiver!=null && !payerReceiver.prune().hasData()) payerReceiver = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getCashflowType()!=null) return true;
			if (getPayerReceiver()!=null && getPayerReceiver().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CashTransferBreakdown.CashTransferBreakdownBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CashTransferBreakdown.CashTransferBreakdownBuilder o = (CashTransferBreakdown.CashTransferBreakdownBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			merger.mergeRosetta(getPayerReceiver(), o.getPayerReceiver(), this::setPayerReceiver);
			
			merger.mergeBasic(getCashflowType(), o.getCashflowType(), this::setCashflowType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CashTransferBreakdown _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(cashflowType, _that.getCashflowType())) return false;
			if (!Objects.equals(payerReceiver, _that.getPayerReceiver())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (cashflowType != null ? cashflowType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (payerReceiver != null ? payerReceiver.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CashTransferBreakdownBuilder {" +
				"amount=" + this.amount + ", " +
				"cashflowType=" + this.cashflowType + ", " +
				"payerReceiver=" + this.payerReceiver +
			'}' + " " + super.toString();
		}
	}
}
