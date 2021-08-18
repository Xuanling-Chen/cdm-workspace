package cdm.regulation;

import cdm.regulation.meta.SnglMeta;
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

public interface Sngl extends RosettaModelObject {
	Sngl build();
	Sngl.SnglBuilder toBuilder();
	
	/**
	 */
	Indx getIndx();
	/**
	 */
	String getIsin();
	final static SnglMeta metaData = new SnglMeta();
	
	@Override
	default RosettaMetaData<? extends Sngl> metaData() {
		return metaData;
	} 
			
	static Sngl.SnglBuilder builder() {
		return new Sngl.SnglBuilderImpl();
	}
	
	default Class<? extends Sngl> getType() {
		return Sngl.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
		
		processRosetta(path.newSubPath("indx"), processor, Indx.class, getIndx());
	}
	
	
	interface SnglBuilder extends Sngl, RosettaModelObjectBuilder {
		Indx.IndxBuilder getOrCreateIndx();
		Indx.IndxBuilder getIndx();
		Sngl.SnglBuilder setIndx(Indx indx);
		Sngl.SnglBuilder setIsin(String isin);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("isin"), String.class, getIsin(), this);
			
			processRosetta(path.newSubPath("indx"), processor, Indx.IndxBuilder.class, getIndx());
		}
		
	}
	
	//Sngl.SnglImpl
	class SnglImpl implements Sngl {
		private final Indx indx;
		private final String isin;
		
		protected SnglImpl(Sngl.SnglBuilder builder) {
			this.indx = ofNullable(builder.getIndx()).map(f->f.build()).orElse(null);
			this.isin = builder.getIsin();
		}
		
		@Override
		public Indx getIndx() {
			return indx;
		}
		
		@Override
		public String getIsin() {
			return isin;
		}
		
		@Override
		public Sngl build() {
			return this;
		}
		
		@Override
		public Sngl.SnglBuilder toBuilder() {
			Sngl.SnglBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Sngl.SnglBuilder builder) {
			ofNullable(getIndx()).ifPresent(builder::setIndx);
			ofNullable(getIsin()).ifPresent(builder::setIsin);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Sngl _that = getType().cast(o);
		
			if (!Objects.equals(indx, _that.getIndx())) return false;
			if (!Objects.equals(isin, _that.getIsin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indx != null ? indx.hashCode() : 0);
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Sngl {" +
				"indx=" + this.indx + ", " +
				"isin=" + this.isin +
			'}';
		}
	}
	
	//Sngl.SnglBuilderImpl
	class SnglBuilderImpl implements Sngl.SnglBuilder {
	
		protected Indx.IndxBuilder indx;
		protected String isin;
	
		public SnglBuilderImpl() {
		}
	
		@Override
		public Indx.IndxBuilder getIndx() {
			return indx;
		}
		
		@Override
		public Indx.IndxBuilder getOrCreateIndx() {
			Indx.IndxBuilder result;
			if (indx!=null) {
				result = indx;
			}
			else {
				result = indx = Indx.builder();
			}
			
			return result;
		}
		
		@Override
		public String getIsin() {
			return isin;
		}
		
	
		@Override
		public Sngl.SnglBuilder setIndx(Indx indx) {
			this.indx = indx==null?null:indx.toBuilder();
			return this;
		}
		@Override
		public Sngl.SnglBuilder setIsin(String isin) {
			this.isin = isin==null?null:isin;
			return this;
		}
		
		@Override
		public Sngl build() {
			return new Sngl.SnglImpl(this);
		}
		
		@Override
		public Sngl.SnglBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Sngl.SnglBuilder prune() {
			if (indx!=null && !indx.prune().hasData()) indx = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndx()!=null && getIndx().hasData()) return true;
			if (getIsin()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Sngl.SnglBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Sngl.SnglBuilder o = (Sngl.SnglBuilder) other;
			
			merger.mergeRosetta(getIndx(), o.getIndx(), this::setIndx);
			
			merger.mergeBasic(getIsin(), o.getIsin(), this::setIsin);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Sngl _that = getType().cast(o);
		
			if (!Objects.equals(indx, _that.getIndx())) return false;
			if (!Objects.equals(isin, _that.getIsin())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (indx != null ? indx.hashCode() : 0);
			_result = 31 * _result + (isin != null ? isin.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SnglBuilder {" +
				"indx=" + this.indx + ", " +
				"isin=" + this.isin +
			'}';
		}
	}
}
