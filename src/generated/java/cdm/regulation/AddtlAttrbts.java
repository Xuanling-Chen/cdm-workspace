package cdm.regulation;

import cdm.regulation.meta.AddtlAttrbtsMeta;
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

public interface AddtlAttrbts extends RosettaModelObject {
	AddtlAttrbts build();
	AddtlAttrbts.AddtlAttrbtsBuilder toBuilder();
	
	/**
	 */
	String getRskRdcgTx();
	/**
	 */
	String getSctiesFincgTxInd();
	final static AddtlAttrbtsMeta metaData = new AddtlAttrbtsMeta();
	
	@Override
	default RosettaMetaData<? extends AddtlAttrbts> metaData() {
		return metaData;
	} 
			
	static AddtlAttrbts.AddtlAttrbtsBuilder builder() {
		return new AddtlAttrbts.AddtlAttrbtsBuilderImpl();
	}
	
	default Class<? extends AddtlAttrbts> getType() {
		return AddtlAttrbts.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rskRdcgTx"), String.class, getRskRdcgTx(), this);
		processor.processBasic(path.newSubPath("sctiesFincgTxInd"), String.class, getSctiesFincgTxInd(), this);
		
	}
	
	
	interface AddtlAttrbtsBuilder extends AddtlAttrbts, RosettaModelObjectBuilder {
		AddtlAttrbts.AddtlAttrbtsBuilder setRskRdcgTx(String rskRdcgTx);
		AddtlAttrbts.AddtlAttrbtsBuilder setSctiesFincgTxInd(String sctiesFincgTxInd);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("rskRdcgTx"), String.class, getRskRdcgTx(), this);
			processor.processBasic(path.newSubPath("sctiesFincgTxInd"), String.class, getSctiesFincgTxInd(), this);
			
		}
		
	}
	
	//AddtlAttrbts.AddtlAttrbtsImpl
	class AddtlAttrbtsImpl implements AddtlAttrbts {
		private final String rskRdcgTx;
		private final String sctiesFincgTxInd;
		
		protected AddtlAttrbtsImpl(AddtlAttrbts.AddtlAttrbtsBuilder builder) {
			this.rskRdcgTx = builder.getRskRdcgTx();
			this.sctiesFincgTxInd = builder.getSctiesFincgTxInd();
		}
		
		@Override
		public String getRskRdcgTx() {
			return rskRdcgTx;
		}
		
		@Override
		public String getSctiesFincgTxInd() {
			return sctiesFincgTxInd;
		}
		
		@Override
		public AddtlAttrbts build() {
			return this;
		}
		
		@Override
		public AddtlAttrbts.AddtlAttrbtsBuilder toBuilder() {
			AddtlAttrbts.AddtlAttrbtsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AddtlAttrbts.AddtlAttrbtsBuilder builder) {
			ofNullable(getRskRdcgTx()).ifPresent(builder::setRskRdcgTx);
			ofNullable(getSctiesFincgTxInd()).ifPresent(builder::setSctiesFincgTxInd);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AddtlAttrbts _that = getType().cast(o);
		
			if (!Objects.equals(rskRdcgTx, _that.getRskRdcgTx())) return false;
			if (!Objects.equals(sctiesFincgTxInd, _that.getSctiesFincgTxInd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rskRdcgTx != null ? rskRdcgTx.hashCode() : 0);
			_result = 31 * _result + (sctiesFincgTxInd != null ? sctiesFincgTxInd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AddtlAttrbts {" +
				"rskRdcgTx=" + this.rskRdcgTx + ", " +
				"sctiesFincgTxInd=" + this.sctiesFincgTxInd +
			'}';
		}
	}
	
	//AddtlAttrbts.AddtlAttrbtsBuilderImpl
	class AddtlAttrbtsBuilderImpl implements AddtlAttrbts.AddtlAttrbtsBuilder {
	
		protected String rskRdcgTx;
		protected String sctiesFincgTxInd;
	
		public AddtlAttrbtsBuilderImpl() {
		}
	
		@Override
		public String getRskRdcgTx() {
			return rskRdcgTx;
		}
		
		@Override
		public String getSctiesFincgTxInd() {
			return sctiesFincgTxInd;
		}
		
	
		@Override
		public AddtlAttrbts.AddtlAttrbtsBuilder setRskRdcgTx(String rskRdcgTx) {
			this.rskRdcgTx = rskRdcgTx==null?null:rskRdcgTx;
			return this;
		}
		@Override
		public AddtlAttrbts.AddtlAttrbtsBuilder setSctiesFincgTxInd(String sctiesFincgTxInd) {
			this.sctiesFincgTxInd = sctiesFincgTxInd==null?null:sctiesFincgTxInd;
			return this;
		}
		
		@Override
		public AddtlAttrbts build() {
			return new AddtlAttrbts.AddtlAttrbtsImpl(this);
		}
		
		@Override
		public AddtlAttrbts.AddtlAttrbtsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AddtlAttrbts.AddtlAttrbtsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRskRdcgTx()!=null) return true;
			if (getSctiesFincgTxInd()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AddtlAttrbts.AddtlAttrbtsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AddtlAttrbts.AddtlAttrbtsBuilder o = (AddtlAttrbts.AddtlAttrbtsBuilder) other;
			
			
			merger.mergeBasic(getRskRdcgTx(), o.getRskRdcgTx(), this::setRskRdcgTx);
			merger.mergeBasic(getSctiesFincgTxInd(), o.getSctiesFincgTxInd(), this::setSctiesFincgTxInd);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AddtlAttrbts _that = getType().cast(o);
		
			if (!Objects.equals(rskRdcgTx, _that.getRskRdcgTx())) return false;
			if (!Objects.equals(sctiesFincgTxInd, _that.getSctiesFincgTxInd())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rskRdcgTx != null ? rskRdcgTx.hashCode() : 0);
			_result = 31 * _result + (sctiesFincgTxInd != null ? sctiesFincgTxInd.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AddtlAttrbtsBuilder {" +
				"rskRdcgTx=" + this.rskRdcgTx + ", " +
				"sctiesFincgTxInd=" + this.sctiesFincgTxInd +
			'}';
		}
	}
}
