package cdm.product.common.settlement;

import cdm.product.common.settlement.SettlementBase.SettlementBaseBuilder;
import cdm.product.common.settlement.SettlementBase.SettlementBaseBuilderImpl;
import cdm.product.common.settlement.SettlementBase.SettlementBaseImpl;
import cdm.product.common.settlement.meta.SettlementTermsMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.model.metafields.MetaFields;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the settlement terms, which can either be cash, physical, or fx-based cash-settlement. This class can be used for the settlement of options and forwards, cash transactions (e.g. securities or foreign exchange), or in case of credit event.
 * @version ${project.version}
 */
@RosettaClass

public interface SettlementTerms extends SettlementBase {
	SettlementTerms build();
	SettlementTerms.SettlementTermsBuilder toBuilder();
	
	/**
	 * Specifies the parameters associated with the cash settlement procedure.
	 */
	List<? extends CashSettlementTerms> getCashSettlementTerms();
	/**
	 * Specifies the physical settlement terms which apply to the transaction.
	 */
	PhysicalSettlementTerms getPhysicalSettlementTerms();
	final static SettlementTermsMeta metaData = new SettlementTermsMeta();
	
	@Override
	default RosettaMetaData<? extends SettlementTerms> metaData() {
		return metaData;
	} 
			
	static SettlementTerms.SettlementTermsBuilder builder() {
		return new SettlementTerms.SettlementTermsBuilderImpl();
	}
	
	default Class<? extends SettlementTerms> getType() {
		return SettlementTerms.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.product.common.settlement.SettlementBase.super.process(path, processor);
		
		processRosetta(path.newSubPath("cashSettlementTerms"), processor, CashSettlementTerms.class, getCashSettlementTerms());
		processRosetta(path.newSubPath("physicalSettlementTerms"), processor, PhysicalSettlementTerms.class, getPhysicalSettlementTerms());
	}
	
	
	interface SettlementTermsBuilder extends SettlementTerms, SettlementBase.SettlementBaseBuilder, RosettaModelObjectBuilder {
		CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlementTerms(int _index);
		List<? extends CashSettlementTerms.CashSettlementTermsBuilder> getCashSettlementTerms();
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms();
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getPhysicalSettlementTerms();
		SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(CashSettlementTerms cashSettlementTerms);
		SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(CashSettlementTerms cashSettlementTerms, int _idx);
		SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(List<? extends CashSettlementTerms> cashSettlementTerms);
		SettlementTerms.SettlementTermsBuilder setCashSettlementTerms(List<? extends CashSettlementTerms> cashSettlementTerms);
		SettlementTerms.SettlementTermsBuilder setPhysicalSettlementTerms(PhysicalSettlementTerms physicalSettlementTerms);
		SettlementTerms.SettlementTermsBuilder setMeta(MetaFields meta);
		SettlementTerms.SettlementTermsBuilder setSettlementCurrency(FieldWithMetaString settlementCurrency);
		SettlementTerms.SettlementTermsBuilder setSettlementCurrencyValue(String settlementCurrency);
		SettlementTerms.SettlementTermsBuilder setSettlementDate(SettlementDate settlementDate);
		SettlementTerms.SettlementTermsBuilder setSettlementType(SettlementTypeEnum settlementType);
		SettlementTerms.SettlementTermsBuilder setTransferSettlementType(TransferSettlementEnum transferSettlementType);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			SettlementBase.SettlementBaseBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("cashSettlementTerms"), processor, CashSettlementTerms.CashSettlementTermsBuilder.class, getCashSettlementTerms());
			processRosetta(path.newSubPath("physicalSettlementTerms"), processor, PhysicalSettlementTerms.PhysicalSettlementTermsBuilder.class, getPhysicalSettlementTerms());
		}
		
	}
	
	//SettlementTerms.SettlementTermsImpl
	class SettlementTermsImpl extends SettlementBase.SettlementBaseImpl implements SettlementTerms {
		private final List<? extends CashSettlementTerms> cashSettlementTerms;
		private final PhysicalSettlementTerms physicalSettlementTerms;
		
		protected SettlementTermsImpl(SettlementTerms.SettlementTermsBuilder builder) {
			super(builder);
			this.cashSettlementTerms = ofNullable(builder.getCashSettlementTerms()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.physicalSettlementTerms = ofNullable(builder.getPhysicalSettlementTerms()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public List<? extends CashSettlementTerms> getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		@Override
		public PhysicalSettlementTerms getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public SettlementTerms build() {
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder toBuilder() {
			SettlementTerms.SettlementTermsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SettlementTerms.SettlementTermsBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCashSettlementTerms()).ifPresent(builder::setCashSettlementTerms);
			ofNullable(getPhysicalSettlementTerms()).ifPresent(builder::setPhysicalSettlementTerms);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementTerms {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms +
			'}' + " " + super.toString();
		}
	}
	
	//SettlementTerms.SettlementTermsBuilderImpl
	class SettlementTermsBuilderImpl extends SettlementBase.SettlementBaseBuilderImpl  implements SettlementTerms.SettlementTermsBuilder {
	
		protected List<CashSettlementTerms.CashSettlementTermsBuilder> cashSettlementTerms = new ArrayList<>();
		protected PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTerms;
	
		public SettlementTermsBuilderImpl() {
		}
	
		@Override
		public List<? extends CashSettlementTerms.CashSettlementTermsBuilder> getCashSettlementTerms() {
			return cashSettlementTerms;
		}
		
		public CashSettlementTerms.CashSettlementTermsBuilder getOrCreateCashSettlementTerms(int _index) {
		
			if (cashSettlementTerms==null) {
				this.cashSettlementTerms = new ArrayList<>();
			}
			CashSettlementTerms.CashSettlementTermsBuilder result;
			return getIndex(cashSettlementTerms, _index, () -> {
						CashSettlementTerms.CashSettlementTermsBuilder newCashSettlementTerms = CashSettlementTerms.builder();
						return newCashSettlementTerms;
					});
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getPhysicalSettlementTerms() {
			return physicalSettlementTerms;
		}
		
		@Override
		public PhysicalSettlementTerms.PhysicalSettlementTermsBuilder getOrCreatePhysicalSettlementTerms() {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder result;
			if (physicalSettlementTerms!=null) {
				result = physicalSettlementTerms;
			}
			else {
				result = physicalSettlementTerms = PhysicalSettlementTerms.builder();
			}
			
			return result;
		}
		
	
		@Override
		public SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(CashSettlementTerms cashSettlementTerms) {
			if (cashSettlementTerms!=null) this.cashSettlementTerms.add(cashSettlementTerms.toBuilder());
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(CashSettlementTerms cashSettlementTerms, int _idx) {
			getIndex(this.cashSettlementTerms, _idx, () -> cashSettlementTerms.toBuilder());
			return this;
		}
		@Override 
		public SettlementTerms.SettlementTermsBuilder addCashSettlementTerms(List<? extends CashSettlementTerms> cashSettlementTermss) {
			if (cashSettlementTermss != null) {
				for (CashSettlementTerms toAdd : cashSettlementTermss) {
					this.cashSettlementTerms.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public SettlementTerms.SettlementTermsBuilder setCashSettlementTerms(List<? extends CashSettlementTerms> cashSettlementTermss) {
			if (cashSettlementTermss == null)  {
				this.cashSettlementTerms = new ArrayList<>();
			}
			else {
				this.cashSettlementTerms = cashSettlementTermss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder setPhysicalSettlementTerms(PhysicalSettlementTerms physicalSettlementTerms) {
			this.physicalSettlementTerms = physicalSettlementTerms==null?null:physicalSettlementTerms.toBuilder();
			return this;
		}
		@Override
		public SettlementTerms.SettlementTermsBuilder setMeta(MetaFields meta) {
			this.meta = meta==null?null:meta.toBuilder();
			return this;
		}
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementCurrency(FieldWithMetaString settlementCurrency) {
			this.settlementCurrency = settlementCurrency==null?null:settlementCurrency.toBuilder();
			return this;
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementCurrencyValue(String settlementCurrency) {
			this.getOrCreateSettlementCurrency().setValue(settlementCurrency);
			return this;
		}
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementDate(SettlementDate settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		public SettlementTerms.SettlementTermsBuilder setSettlementType(SettlementTypeEnum settlementType) {
			this.settlementType = settlementType==null?null:settlementType;
			return this;
		}
		@Override
		public SettlementTerms.SettlementTermsBuilder setTransferSettlementType(TransferSettlementEnum transferSettlementType) {
			this.transferSettlementType = transferSettlementType==null?null:transferSettlementType;
			return this;
		}
		
		@Override
		public SettlementTerms build() {
			return new SettlementTerms.SettlementTermsImpl(this);
		}
		
		@Override
		public SettlementTerms.SettlementTermsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementTerms.SettlementTermsBuilder prune() {
			super.prune();
			cashSettlementTerms = cashSettlementTerms.stream().filter(b->b!=null).<CashSettlementTerms.CashSettlementTermsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (physicalSettlementTerms!=null && !physicalSettlementTerms.prune().hasData()) physicalSettlementTerms = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCashSettlementTerms()!=null && getCashSettlementTerms().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPhysicalSettlementTerms()!=null && getPhysicalSettlementTerms().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SettlementTerms.SettlementTermsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			SettlementTerms.SettlementTermsBuilder o = (SettlementTerms.SettlementTermsBuilder) other;
			
			merger.mergeRosetta(getCashSettlementTerms(), o.getCashSettlementTerms(), this::getOrCreateCashSettlementTerms);
			merger.mergeRosetta(getPhysicalSettlementTerms(), o.getPhysicalSettlementTerms(), this::setPhysicalSettlementTerms);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			SettlementTerms _that = getType().cast(o);
		
			if (!ListEquals.listEquals(cashSettlementTerms, _that.getCashSettlementTerms())) return false;
			if (!Objects.equals(physicalSettlementTerms, _that.getPhysicalSettlementTerms())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (cashSettlementTerms != null ? cashSettlementTerms.hashCode() : 0);
			_result = 31 * _result + (physicalSettlementTerms != null ? physicalSettlementTerms.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SettlementTermsBuilder {" +
				"cashSettlementTerms=" + this.cashSettlementTerms + ", " +
				"physicalSettlementTerms=" + this.physicalSettlementTerms +
			'}' + " " + super.toString();
		}
	}
}
