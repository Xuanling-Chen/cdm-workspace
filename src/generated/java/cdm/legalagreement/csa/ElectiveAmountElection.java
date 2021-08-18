package cdm.legalagreement.csa;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legalagreement.csa.meta.ElectiveAmountElectionMeta;
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
 * A class to specify the party elective amounts which can be used for the purpose of specifying elections such as the ISDA CSA Threshold and Minimum Transfer Amount.
 * @version ${project.version}
 */
@RosettaClass

public interface ElectiveAmountElection extends RosettaModelObject {
	ElectiveAmountElection build();
	ElectiveAmountElection.ElectiveAmountElectionBuilder toBuilder();
	
	/**
	 * The elective amount when expressed as a currency amount. The associated PartyElectiveAmount_amount data rule enforces that the currency amount is actually greater than 0.
	 */
	Money getAmount();
	/**
	 * The elective amount when expressed as a custom election by the party.
	 */
	String getCustomElection();
	/**
	 * Specifies an enumerated election to express the elective amount.
	 */
	ElectiveAmountEnum getElectiveAmount();
	/**
	 * The elective party.
	 */
	CounterpartyRoleEnum getParty();
	final static ElectiveAmountElectionMeta metaData = new ElectiveAmountElectionMeta();
	
	@Override
	default RosettaMetaData<? extends ElectiveAmountElection> metaData() {
		return metaData;
	} 
			
	static ElectiveAmountElection.ElectiveAmountElectionBuilder builder() {
		return new ElectiveAmountElection.ElectiveAmountElectionBuilderImpl();
	}
	
	default Class<? extends ElectiveAmountElection> getType() {
		return ElectiveAmountElection.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
		processor.processBasic(path.newSubPath("electiveAmount"), ElectiveAmountEnum.class, getElectiveAmount(), this);
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		
		processRosetta(path.newSubPath("amount"), processor, Money.class, getAmount());
	}
	
	
	interface ElectiveAmountElectionBuilder extends ElectiveAmountElection, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateAmount();
		Money.MoneyBuilder getAmount();
		ElectiveAmountElection.ElectiveAmountElectionBuilder setAmount(Money amount);
		ElectiveAmountElection.ElectiveAmountElectionBuilder setCustomElection(String customElection);
		ElectiveAmountElection.ElectiveAmountElectionBuilder setElectiveAmount(ElectiveAmountEnum electiveAmount);
		ElectiveAmountElection.ElectiveAmountElectionBuilder setParty(CounterpartyRoleEnum party);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("customElection"), String.class, getCustomElection(), this);
			processor.processBasic(path.newSubPath("electiveAmount"), ElectiveAmountEnum.class, getElectiveAmount(), this);
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			
			processRosetta(path.newSubPath("amount"), processor, Money.MoneyBuilder.class, getAmount());
		}
		
	}
	
	//ElectiveAmountElection.ElectiveAmountElectionImpl
	class ElectiveAmountElectionImpl implements ElectiveAmountElection {
		private final Money amount;
		private final String customElection;
		private final ElectiveAmountEnum electiveAmount;
		private final CounterpartyRoleEnum party;
		
		protected ElectiveAmountElectionImpl(ElectiveAmountElection.ElectiveAmountElectionBuilder builder) {
			this.amount = ofNullable(builder.getAmount()).map(f->f.build()).orElse(null);
			this.customElection = builder.getCustomElection();
			this.electiveAmount = builder.getElectiveAmount();
			this.party = builder.getParty();
		}
		
		@Override
		public Money getAmount() {
			return amount;
		}
		
		@Override
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public ElectiveAmountEnum getElectiveAmount() {
			return electiveAmount;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		public ElectiveAmountElection build() {
			return this;
		}
		
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder toBuilder() {
			ElectiveAmountElection.ElectiveAmountElectionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectiveAmountElection.ElectiveAmountElectionBuilder builder) {
			ofNullable(getAmount()).ifPresent(builder::setAmount);
			ofNullable(getCustomElection()).ifPresent(builder::setCustomElection);
			ofNullable(getElectiveAmount()).ifPresent(builder::setElectiveAmount);
			ofNullable(getParty()).ifPresent(builder::setParty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectiveAmountElection _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(electiveAmount, _that.getElectiveAmount())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (electiveAmount != null ? electiveAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectiveAmountElection {" +
				"amount=" + this.amount + ", " +
				"customElection=" + this.customElection + ", " +
				"electiveAmount=" + this.electiveAmount + ", " +
				"party=" + this.party +
			'}';
		}
	}
	
	//ElectiveAmountElection.ElectiveAmountElectionBuilderImpl
	class ElectiveAmountElectionBuilderImpl implements ElectiveAmountElection.ElectiveAmountElectionBuilder {
	
		protected Money.MoneyBuilder amount;
		protected String customElection;
		protected ElectiveAmountEnum electiveAmount;
		protected CounterpartyRoleEnum party;
	
		public ElectiveAmountElectionBuilderImpl() {
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
		public String getCustomElection() {
			return customElection;
		}
		
		@Override
		public ElectiveAmountEnum getElectiveAmount() {
			return electiveAmount;
		}
		
		@Override
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
	
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder setAmount(Money amount) {
			this.amount = amount==null?null:amount.toBuilder();
			return this;
		}
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder setCustomElection(String customElection) {
			this.customElection = customElection==null?null:customElection;
			return this;
		}
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder setElectiveAmount(ElectiveAmountEnum electiveAmount) {
			this.electiveAmount = electiveAmount==null?null:electiveAmount;
			return this;
		}
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder setParty(CounterpartyRoleEnum party) {
			this.party = party==null?null:party;
			return this;
		}
		
		@Override
		public ElectiveAmountElection build() {
			return new ElectiveAmountElection.ElectiveAmountElectionImpl(this);
		}
		
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder prune() {
			if (amount!=null && !amount.prune().hasData()) amount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAmount()!=null && getAmount().hasData()) return true;
			if (getCustomElection()!=null) return true;
			if (getElectiveAmount()!=null) return true;
			if (getParty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectiveAmountElection.ElectiveAmountElectionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectiveAmountElection.ElectiveAmountElectionBuilder o = (ElectiveAmountElection.ElectiveAmountElectionBuilder) other;
			
			merger.mergeRosetta(getAmount(), o.getAmount(), this::setAmount);
			
			merger.mergeBasic(getCustomElection(), o.getCustomElection(), this::setCustomElection);
			merger.mergeBasic(getElectiveAmount(), o.getElectiveAmount(), this::setElectiveAmount);
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectiveAmountElection _that = getType().cast(o);
		
			if (!Objects.equals(amount, _that.getAmount())) return false;
			if (!Objects.equals(customElection, _that.getCustomElection())) return false;
			if (!Objects.equals(electiveAmount, _that.getElectiveAmount())) return false;
			if (!Objects.equals(party, _that.getParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (amount != null ? amount.hashCode() : 0);
			_result = 31 * _result + (customElection != null ? customElection.hashCode() : 0);
			_result = 31 * _result + (electiveAmount != null ? electiveAmount.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectiveAmountElectionBuilder {" +
				"amount=" + this.amount + ", " +
				"customElection=" + this.customElection + ", " +
				"electiveAmount=" + this.electiveAmount + ", " +
				"party=" + this.party +
			'}';
		}
	}
}
