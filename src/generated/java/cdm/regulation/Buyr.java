package cdm.regulation;

import cdm.regulation.meta.BuyrMeta;
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

public interface Buyr extends RosettaModelObject {
	Buyr build();
	Buyr.BuyrBuilder toBuilder();
	
	/**
	 */
	AcctOwnr getAcctOwnr();
	final static BuyrMeta metaData = new BuyrMeta();
	
	@Override
	default RosettaMetaData<? extends Buyr> metaData() {
		return metaData;
	} 
			
	static Buyr.BuyrBuilder builder() {
		return new Buyr.BuyrBuilderImpl();
	}
	
	default Class<? extends Buyr> getType() {
		return Buyr.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("acctOwnr"), processor, AcctOwnr.class, getAcctOwnr());
	}
	
	
	interface BuyrBuilder extends Buyr, RosettaModelObjectBuilder {
		AcctOwnr.AcctOwnrBuilder getOrCreateAcctOwnr();
		AcctOwnr.AcctOwnrBuilder getAcctOwnr();
		Buyr.BuyrBuilder setAcctOwnr(AcctOwnr acctOwnr);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("acctOwnr"), processor, AcctOwnr.AcctOwnrBuilder.class, getAcctOwnr());
		}
		
	}
	
	//Buyr.BuyrImpl
	class BuyrImpl implements Buyr {
		private final AcctOwnr acctOwnr;
		
		protected BuyrImpl(Buyr.BuyrBuilder builder) {
			this.acctOwnr = ofNullable(builder.getAcctOwnr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AcctOwnr getAcctOwnr() {
			return acctOwnr;
		}
		
		@Override
		public Buyr build() {
			return this;
		}
		
		@Override
		public Buyr.BuyrBuilder toBuilder() {
			Buyr.BuyrBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Buyr.BuyrBuilder builder) {
			ofNullable(getAcctOwnr()).ifPresent(builder::setAcctOwnr);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Buyr _that = getType().cast(o);
		
			if (!Objects.equals(acctOwnr, _that.getAcctOwnr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (acctOwnr != null ? acctOwnr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Buyr {" +
				"acctOwnr=" + this.acctOwnr +
			'}';
		}
	}
	
	//Buyr.BuyrBuilderImpl
	class BuyrBuilderImpl implements Buyr.BuyrBuilder {
	
		protected AcctOwnr.AcctOwnrBuilder acctOwnr;
	
		public BuyrBuilderImpl() {
		}
	
		@Override
		public AcctOwnr.AcctOwnrBuilder getAcctOwnr() {
			return acctOwnr;
		}
		
		@Override
		public AcctOwnr.AcctOwnrBuilder getOrCreateAcctOwnr() {
			AcctOwnr.AcctOwnrBuilder result;
			if (acctOwnr!=null) {
				result = acctOwnr;
			}
			else {
				result = acctOwnr = AcctOwnr.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Buyr.BuyrBuilder setAcctOwnr(AcctOwnr acctOwnr) {
			this.acctOwnr = acctOwnr==null?null:acctOwnr.toBuilder();
			return this;
		}
		
		@Override
		public Buyr build() {
			return new Buyr.BuyrImpl(this);
		}
		
		@Override
		public Buyr.BuyrBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Buyr.BuyrBuilder prune() {
			if (acctOwnr!=null && !acctOwnr.prune().hasData()) acctOwnr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAcctOwnr()!=null && getAcctOwnr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Buyr.BuyrBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Buyr.BuyrBuilder o = (Buyr.BuyrBuilder) other;
			
			merger.mergeRosetta(getAcctOwnr(), o.getAcctOwnr(), this::setAcctOwnr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Buyr _that = getType().cast(o);
		
			if (!Objects.equals(acctOwnr, _that.getAcctOwnr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (acctOwnr != null ? acctOwnr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BuyrBuilder {" +
				"acctOwnr=" + this.acctOwnr +
			'}';
		}
	}
}
