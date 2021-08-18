package cdm.regulation;

import cdm.regulation.meta.TxMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface Tx extends RosettaModelObject {
	Tx build();
	Tx.TxBuilder toBuilder();
	
	/**
	 */
	String getCtryOfBrnch();
	/**
	 */
	New getNewTx();
	/**
	 */
	Pric getPric();
	/**
	 */
	Qty getQty();
	/**
	 */
	String getTradDt();
	/**
	 */
	String getTradVn();
	/**
	 */
	String getTradgCpcty();
	final static TxMeta metaData = new TxMeta();
	
	@Override
	default RosettaMetaData<? extends Tx> metaData() {
		return metaData;
	} 
			
	static Tx.TxBuilder builder() {
		return new Tx.TxBuilderImpl();
	}
	
	default Class<? extends Tx> getType() {
		return Tx.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("ctryOfBrnch"), String.class, getCtryOfBrnch(), this);
		processor.processBasic(path.newSubPath("tradDt"), String.class, getTradDt(), this);
		processor.processBasic(path.newSubPath("tradVn"), String.class, getTradVn(), this);
		processor.processBasic(path.newSubPath("tradgCpcty"), String.class, getTradgCpcty(), this);
		
		processRosetta(path.newSubPath("newTx"), processor, New.class, getNewTx());
		processRosetta(path.newSubPath("pric"), processor, Pric.class, getPric());
		processRosetta(path.newSubPath("qty"), processor, Qty.class, getQty());
	}
	
	
	interface TxBuilder extends Tx, RosettaModelObjectBuilder {
		New.NewBuilder getOrCreateNewTx();
		New.NewBuilder getNewTx();
		Pric.PricBuilder getOrCreatePric();
		Pric.PricBuilder getPric();
		Qty.QtyBuilder getOrCreateQty();
		Qty.QtyBuilder getQty();
		Tx.TxBuilder setCtryOfBrnch(String ctryOfBrnch);
		Tx.TxBuilder setNewTx(New newTx);
		Tx.TxBuilder setPric(Pric pric);
		Tx.TxBuilder setQty(Qty qty);
		Tx.TxBuilder setTradDt(String tradDt);
		Tx.TxBuilder setTradVn(String tradVn);
		Tx.TxBuilder setTradgCpcty(String tradgCpcty);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("ctryOfBrnch"), String.class, getCtryOfBrnch(), this);
			processor.processBasic(path.newSubPath("tradDt"), String.class, getTradDt(), this);
			processor.processBasic(path.newSubPath("tradVn"), String.class, getTradVn(), this);
			processor.processBasic(path.newSubPath("tradgCpcty"), String.class, getTradgCpcty(), this);
			
			processRosetta(path.newSubPath("newTx"), processor, New.NewBuilder.class, getNewTx());
			processRosetta(path.newSubPath("pric"), processor, Pric.PricBuilder.class, getPric());
			processRosetta(path.newSubPath("qty"), processor, Qty.QtyBuilder.class, getQty());
		}
		
	}
	
	//Tx.TxImpl
	class TxImpl implements Tx {
		private final String ctryOfBrnch;
		private final New newTx;
		private final Pric pric;
		private final Qty qty;
		private final String tradDt;
		private final String tradVn;
		private final String tradgCpcty;
		
		protected TxImpl(Tx.TxBuilder builder) {
			this.ctryOfBrnch = builder.getCtryOfBrnch();
			this.newTx = ofNullable(builder.getNewTx()).map(f->f.build()).orElse(null);
			this.pric = ofNullable(builder.getPric()).map(f->f.build()).orElse(null);
			this.qty = ofNullable(builder.getQty()).map(f->f.build()).orElse(null);
			this.tradDt = builder.getTradDt();
			this.tradVn = builder.getTradVn();
			this.tradgCpcty = builder.getTradgCpcty();
		}
		
		@Override
		public String getCtryOfBrnch() {
			return ctryOfBrnch;
		}
		
		@Override
		public New getNewTx() {
			return newTx;
		}
		
		@Override
		public Pric getPric() {
			return pric;
		}
		
		@Override
		public Qty getQty() {
			return qty;
		}
		
		@Override
		public String getTradDt() {
			return tradDt;
		}
		
		@Override
		public String getTradVn() {
			return tradVn;
		}
		
		@Override
		public String getTradgCpcty() {
			return tradgCpcty;
		}
		
		@Override
		public Tx build() {
			return this;
		}
		
		@Override
		public Tx.TxBuilder toBuilder() {
			Tx.TxBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Tx.TxBuilder builder) {
			ofNullable(getCtryOfBrnch()).ifPresent(builder::setCtryOfBrnch);
			ofNullable(getNewTx()).ifPresent(builder::setNewTx);
			ofNullable(getPric()).ifPresent(builder::setPric);
			ofNullable(getQty()).ifPresent(builder::setQty);
			ofNullable(getTradDt()).ifPresent(builder::setTradDt);
			ofNullable(getTradVn()).ifPresent(builder::setTradVn);
			ofNullable(getTradgCpcty()).ifPresent(builder::setTradgCpcty);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Tx _that = getType().cast(o);
		
			if (!Objects.equals(ctryOfBrnch, _that.getCtryOfBrnch())) return false;
			if (!Objects.equals(newTx, _that.getNewTx())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			if (!Objects.equals(qty, _that.getQty())) return false;
			if (!Objects.equals(tradDt, _that.getTradDt())) return false;
			if (!Objects.equals(tradVn, _that.getTradVn())) return false;
			if (!Objects.equals(tradgCpcty, _that.getTradgCpcty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctryOfBrnch != null ? ctryOfBrnch.hashCode() : 0);
			_result = 31 * _result + (newTx != null ? newTx.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			_result = 31 * _result + (tradDt != null ? tradDt.hashCode() : 0);
			_result = 31 * _result + (tradVn != null ? tradVn.hashCode() : 0);
			_result = 31 * _result + (tradgCpcty != null ? tradgCpcty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Tx {" +
				"ctryOfBrnch=" + this.ctryOfBrnch + ", " +
				"newTx=" + this.newTx + ", " +
				"pric=" + this.pric + ", " +
				"qty=" + this.qty + ", " +
				"tradDt=" + this.tradDt + ", " +
				"tradVn=" + this.tradVn + ", " +
				"tradgCpcty=" + this.tradgCpcty +
			'}';
		}
	}
	
	//Tx.TxBuilderImpl
	class TxBuilderImpl implements Tx.TxBuilder {
	
		protected String ctryOfBrnch;
		protected New.NewBuilder newTx;
		protected Pric.PricBuilder pric;
		protected Qty.QtyBuilder qty;
		protected String tradDt;
		protected String tradVn;
		protected String tradgCpcty;
	
		public TxBuilderImpl() {
		}
	
		@Override
		public String getCtryOfBrnch() {
			return ctryOfBrnch;
		}
		
		@Override
		public New.NewBuilder getNewTx() {
			return newTx;
		}
		
		@Override
		public New.NewBuilder getOrCreateNewTx() {
			New.NewBuilder result;
			if (newTx!=null) {
				result = newTx;
			}
			else {
				result = newTx = New.builder();
			}
			
			return result;
		}
		
		@Override
		public Pric.PricBuilder getPric() {
			return pric;
		}
		
		@Override
		public Pric.PricBuilder getOrCreatePric() {
			Pric.PricBuilder result;
			if (pric!=null) {
				result = pric;
			}
			else {
				result = pric = Pric.builder();
			}
			
			return result;
		}
		
		@Override
		public Qty.QtyBuilder getQty() {
			return qty;
		}
		
		@Override
		public Qty.QtyBuilder getOrCreateQty() {
			Qty.QtyBuilder result;
			if (qty!=null) {
				result = qty;
			}
			else {
				result = qty = Qty.builder();
			}
			
			return result;
		}
		
		@Override
		public String getTradDt() {
			return tradDt;
		}
		
		@Override
		public String getTradVn() {
			return tradVn;
		}
		
		@Override
		public String getTradgCpcty() {
			return tradgCpcty;
		}
		
	
		@Override
		public Tx.TxBuilder setCtryOfBrnch(String ctryOfBrnch) {
			this.ctryOfBrnch = ctryOfBrnch==null?null:ctryOfBrnch;
			return this;
		}
		@Override
		public Tx.TxBuilder setNewTx(New newTx) {
			this.newTx = newTx==null?null:newTx.toBuilder();
			return this;
		}
		@Override
		public Tx.TxBuilder setPric(Pric pric) {
			this.pric = pric==null?null:pric.toBuilder();
			return this;
		}
		@Override
		public Tx.TxBuilder setQty(Qty qty) {
			this.qty = qty==null?null:qty.toBuilder();
			return this;
		}
		@Override
		public Tx.TxBuilder setTradDt(String tradDt) {
			this.tradDt = tradDt==null?null:tradDt;
			return this;
		}
		@Override
		public Tx.TxBuilder setTradVn(String tradVn) {
			this.tradVn = tradVn==null?null:tradVn;
			return this;
		}
		@Override
		public Tx.TxBuilder setTradgCpcty(String tradgCpcty) {
			this.tradgCpcty = tradgCpcty==null?null:tradgCpcty;
			return this;
		}
		
		@Override
		public Tx build() {
			return new Tx.TxImpl(this);
		}
		
		@Override
		public Tx.TxBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Tx.TxBuilder prune() {
			if (newTx!=null && !newTx.prune().hasData()) newTx = null;
			if (pric!=null && !pric.prune().hasData()) pric = null;
			if (qty!=null && !qty.prune().hasData()) qty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCtryOfBrnch()!=null) return true;
			if (getNewTx()!=null && getNewTx().hasData()) return true;
			if (getPric()!=null && getPric().hasData()) return true;
			if (getQty()!=null && getQty().hasData()) return true;
			if (getTradDt()!=null) return true;
			if (getTradVn()!=null) return true;
			if (getTradgCpcty()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Tx.TxBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Tx.TxBuilder o = (Tx.TxBuilder) other;
			
			merger.mergeRosetta(getNewTx(), o.getNewTx(), this::setNewTx);
			merger.mergeRosetta(getPric(), o.getPric(), this::setPric);
			merger.mergeRosetta(getQty(), o.getQty(), this::setQty);
			
			merger.mergeBasic(getCtryOfBrnch(), o.getCtryOfBrnch(), this::setCtryOfBrnch);
			merger.mergeBasic(getTradDt(), o.getTradDt(), this::setTradDt);
			merger.mergeBasic(getTradVn(), o.getTradVn(), this::setTradVn);
			merger.mergeBasic(getTradgCpcty(), o.getTradgCpcty(), this::setTradgCpcty);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Tx _that = getType().cast(o);
		
			if (!Objects.equals(ctryOfBrnch, _that.getCtryOfBrnch())) return false;
			if (!Objects.equals(newTx, _that.getNewTx())) return false;
			if (!Objects.equals(pric, _that.getPric())) return false;
			if (!Objects.equals(qty, _that.getQty())) return false;
			if (!Objects.equals(tradDt, _that.getTradDt())) return false;
			if (!Objects.equals(tradVn, _that.getTradVn())) return false;
			if (!Objects.equals(tradgCpcty, _that.getTradgCpcty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (ctryOfBrnch != null ? ctryOfBrnch.hashCode() : 0);
			_result = 31 * _result + (newTx != null ? newTx.hashCode() : 0);
			_result = 31 * _result + (pric != null ? pric.hashCode() : 0);
			_result = 31 * _result + (qty != null ? qty.hashCode() : 0);
			_result = 31 * _result + (tradDt != null ? tradDt.hashCode() : 0);
			_result = 31 * _result + (tradVn != null ? tradVn.hashCode() : 0);
			_result = 31 * _result + (tradgCpcty != null ? tradgCpcty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TxBuilder {" +
				"ctryOfBrnch=" + this.ctryOfBrnch + ", " +
				"newTx=" + this.newTx + ", " +
				"pric=" + this.pric + ", " +
				"qty=" + this.qty + ", " +
				"tradDt=" + this.tradDt + ", " +
				"tradVn=" + this.tradVn + ", " +
				"tradgCpcty=" + this.tradgCpcty +
			'}';
		}
	}
}
