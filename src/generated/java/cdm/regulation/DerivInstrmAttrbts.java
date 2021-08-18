package cdm.regulation;

import cdm.regulation.meta.DerivInstrmAttrbtsMeta;
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

public interface DerivInstrmAttrbts extends RosettaModelObject {
	DerivInstrmAttrbts build();
	DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder toBuilder();
	
	/**
	 */
	String getDlvryTp();
	/**
	 */
	String getPricMltplr();
	/**
	 */
	UndrlygInstrm getUndrlygInstrm();
	/**
	 */
	String getXpryDt();
	final static DerivInstrmAttrbtsMeta metaData = new DerivInstrmAttrbtsMeta();
	
	@Override
	default RosettaMetaData<? extends DerivInstrmAttrbts> metaData() {
		return metaData;
	} 
			
	static DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder builder() {
		return new DerivInstrmAttrbts.DerivInstrmAttrbtsBuilderImpl();
	}
	
	default Class<? extends DerivInstrmAttrbts> getType() {
		return DerivInstrmAttrbts.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("dlvryTp"), String.class, getDlvryTp(), this);
		processor.processBasic(path.newSubPath("pricMltplr"), String.class, getPricMltplr(), this);
		processor.processBasic(path.newSubPath("xpryDt"), String.class, getXpryDt(), this);
		
		processRosetta(path.newSubPath("undrlygInstrm"), processor, UndrlygInstrm.class, getUndrlygInstrm());
	}
	
	
	interface DerivInstrmAttrbtsBuilder extends DerivInstrmAttrbts, RosettaModelObjectBuilder {
		UndrlygInstrm.UndrlygInstrmBuilder getOrCreateUndrlygInstrm();
		UndrlygInstrm.UndrlygInstrmBuilder getUndrlygInstrm();
		DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder setDlvryTp(String dlvryTp);
		DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder setPricMltplr(String pricMltplr);
		DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder setUndrlygInstrm(UndrlygInstrm undrlygInstrm);
		DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder setXpryDt(String xpryDt);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("dlvryTp"), String.class, getDlvryTp(), this);
			processor.processBasic(path.newSubPath("pricMltplr"), String.class, getPricMltplr(), this);
			processor.processBasic(path.newSubPath("xpryDt"), String.class, getXpryDt(), this);
			
			processRosetta(path.newSubPath("undrlygInstrm"), processor, UndrlygInstrm.UndrlygInstrmBuilder.class, getUndrlygInstrm());
		}
		
	}
	
	//DerivInstrmAttrbts.DerivInstrmAttrbtsImpl
	class DerivInstrmAttrbtsImpl implements DerivInstrmAttrbts {
		private final String dlvryTp;
		private final String pricMltplr;
		private final UndrlygInstrm undrlygInstrm;
		private final String xpryDt;
		
		protected DerivInstrmAttrbtsImpl(DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder builder) {
			this.dlvryTp = builder.getDlvryTp();
			this.pricMltplr = builder.getPricMltplr();
			this.undrlygInstrm = ofNullable(builder.getUndrlygInstrm()).map(f->f.build()).orElse(null);
			this.xpryDt = builder.getXpryDt();
		}
		
		@Override
		public String getDlvryTp() {
			return dlvryTp;
		}
		
		@Override
		public String getPricMltplr() {
			return pricMltplr;
		}
		
		@Override
		public UndrlygInstrm getUndrlygInstrm() {
			return undrlygInstrm;
		}
		
		@Override
		public String getXpryDt() {
			return xpryDt;
		}
		
		@Override
		public DerivInstrmAttrbts build() {
			return this;
		}
		
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder toBuilder() {
			DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder builder) {
			ofNullable(getDlvryTp()).ifPresent(builder::setDlvryTp);
			ofNullable(getPricMltplr()).ifPresent(builder::setPricMltplr);
			ofNullable(getUndrlygInstrm()).ifPresent(builder::setUndrlygInstrm);
			ofNullable(getXpryDt()).ifPresent(builder::setXpryDt);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivInstrmAttrbts _that = getType().cast(o);
		
			if (!Objects.equals(dlvryTp, _that.getDlvryTp())) return false;
			if (!Objects.equals(pricMltplr, _that.getPricMltplr())) return false;
			if (!Objects.equals(undrlygInstrm, _that.getUndrlygInstrm())) return false;
			if (!Objects.equals(xpryDt, _that.getXpryDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dlvryTp != null ? dlvryTp.hashCode() : 0);
			_result = 31 * _result + (pricMltplr != null ? pricMltplr.hashCode() : 0);
			_result = 31 * _result + (undrlygInstrm != null ? undrlygInstrm.hashCode() : 0);
			_result = 31 * _result + (xpryDt != null ? xpryDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivInstrmAttrbts {" +
				"dlvryTp=" + this.dlvryTp + ", " +
				"pricMltplr=" + this.pricMltplr + ", " +
				"undrlygInstrm=" + this.undrlygInstrm + ", " +
				"xpryDt=" + this.xpryDt +
			'}';
		}
	}
	
	//DerivInstrmAttrbts.DerivInstrmAttrbtsBuilderImpl
	class DerivInstrmAttrbtsBuilderImpl implements DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder {
	
		protected String dlvryTp;
		protected String pricMltplr;
		protected UndrlygInstrm.UndrlygInstrmBuilder undrlygInstrm;
		protected String xpryDt;
	
		public DerivInstrmAttrbtsBuilderImpl() {
		}
	
		@Override
		public String getDlvryTp() {
			return dlvryTp;
		}
		
		@Override
		public String getPricMltplr() {
			return pricMltplr;
		}
		
		@Override
		public UndrlygInstrm.UndrlygInstrmBuilder getUndrlygInstrm() {
			return undrlygInstrm;
		}
		
		@Override
		public UndrlygInstrm.UndrlygInstrmBuilder getOrCreateUndrlygInstrm() {
			UndrlygInstrm.UndrlygInstrmBuilder result;
			if (undrlygInstrm!=null) {
				result = undrlygInstrm;
			}
			else {
				result = undrlygInstrm = UndrlygInstrm.builder();
			}
			
			return result;
		}
		
		@Override
		public String getXpryDt() {
			return xpryDt;
		}
		
	
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder setDlvryTp(String dlvryTp) {
			this.dlvryTp = dlvryTp==null?null:dlvryTp;
			return this;
		}
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder setPricMltplr(String pricMltplr) {
			this.pricMltplr = pricMltplr==null?null:pricMltplr;
			return this;
		}
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder setUndrlygInstrm(UndrlygInstrm undrlygInstrm) {
			this.undrlygInstrm = undrlygInstrm==null?null:undrlygInstrm.toBuilder();
			return this;
		}
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder setXpryDt(String xpryDt) {
			this.xpryDt = xpryDt==null?null:xpryDt;
			return this;
		}
		
		@Override
		public DerivInstrmAttrbts build() {
			return new DerivInstrmAttrbts.DerivInstrmAttrbtsImpl(this);
		}
		
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder prune() {
			if (undrlygInstrm!=null && !undrlygInstrm.prune().hasData()) undrlygInstrm = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDlvryTp()!=null) return true;
			if (getPricMltplr()!=null) return true;
			if (getUndrlygInstrm()!=null && getUndrlygInstrm().hasData()) return true;
			if (getXpryDt()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder o = (DerivInstrmAttrbts.DerivInstrmAttrbtsBuilder) other;
			
			merger.mergeRosetta(getUndrlygInstrm(), o.getUndrlygInstrm(), this::setUndrlygInstrm);
			
			merger.mergeBasic(getDlvryTp(), o.getDlvryTp(), this::setDlvryTp);
			merger.mergeBasic(getPricMltplr(), o.getPricMltplr(), this::setPricMltplr);
			merger.mergeBasic(getXpryDt(), o.getXpryDt(), this::setXpryDt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivInstrmAttrbts _that = getType().cast(o);
		
			if (!Objects.equals(dlvryTp, _that.getDlvryTp())) return false;
			if (!Objects.equals(pricMltplr, _that.getPricMltplr())) return false;
			if (!Objects.equals(undrlygInstrm, _that.getUndrlygInstrm())) return false;
			if (!Objects.equals(xpryDt, _that.getXpryDt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (dlvryTp != null ? dlvryTp.hashCode() : 0);
			_result = 31 * _result + (pricMltplr != null ? pricMltplr.hashCode() : 0);
			_result = 31 * _result + (undrlygInstrm != null ? undrlygInstrm.hashCode() : 0);
			_result = 31 * _result + (xpryDt != null ? xpryDt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivInstrmAttrbtsBuilder {" +
				"dlvryTp=" + this.dlvryTp + ", " +
				"pricMltplr=" + this.pricMltplr + ", " +
				"undrlygInstrm=" + this.undrlygInstrm + ", " +
				"xpryDt=" + this.xpryDt +
			'}';
		}
	}
}
